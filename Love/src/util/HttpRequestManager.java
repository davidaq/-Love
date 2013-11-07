package util;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.DefaultHttpClient;

import util.RequestObject.KeyValuePair;
import android.os.Handler;
import android.os.Message;

import com.google.gson.Gson;

public final class HttpRequestManager implements Runnable {
	public final static HttpRequestManager manager = new HttpRequestManager();

	private HttpRequestManager() {

	}

	static class RequestComparator implements Comparator<RequestObject<?>> {
		public int compare(RequestObject<?> arg0, RequestObject<?> arg1) {
			long t0 = arg0.getRequestTime();
			long t1 = arg1.getRequestTime();
			if (t0 == t1)
				return 0;
			if (Math.abs(t0 - t1) > 5000) {
				if(t0 > t1) {
					t0 -= 20000;
				} else {
					t1 -= 20000;
				}
					
			}
			return (t0 > t1) ? 1 : -1;
		}
	}

	private PriorityQueue<RequestObject<?>> queue = new PriorityQueue<RequestObject<?>>(
			10, new RequestComparator());

	private Executor exec = Executors.newFixedThreadPool(2);

	public void enque(RequestObject<?> request) {
		synchronized (queue) {
			queue.add(request);
		}
		exec.execute(this);
	}

	public static void buildRequest(RequestObject<?> requestObj,
			HttpPost request) throws Exception {
		List<KeyValuePair> params = requestObj.getParams();
		MultipartEntityBuilder entityBuilder = null;
		boolean useJson = true;
		if (params != null) {
			useJson = false;
			if (entityBuilder == null)
				entityBuilder = MultipartEntityBuilder.create();
			for (KeyValuePair item : params) {
				entityBuilder.addTextBody(item.key, item.value);
			}
		}
		Object bodyObj = requestObj.getObj();
		if (bodyObj != null) {
			Field fields[] = bodyObj.getClass().getDeclaredFields();
			for (Field f : fields) {
				if (f.getType() == File.class) {
					useJson = false;
					break;
				}
			}
			if (useJson) {
				request.setHeader("Content_type", "application/json");
				Gson gson = new Gson();
				request.setEntity(new StringEntity(gson.toJson(bodyObj)));
			} else {
				if (entityBuilder == null)
					entityBuilder = MultipartEntityBuilder.create();
				for (Field f : fields) {
					if (f.getType() == File.class) {
						entityBuilder.addBinaryBody("filedata",
								(File) f.get(bodyObj));
					} else {
						entityBuilder.addTextBody(f.getName(), f.get(bodyObj)
								.toString());
					}
				}
			}
		}
		if (!useJson && entityBuilder != null) {
			request.setHeader("Content_type", "multipart/form-data");
			request.setEntity(entityBuilder.build());
		}
	}

	public void run() {
		RequestObject<?> requestObj = null;
		synchronized (queue) {
			if (!queue.isEmpty())
				requestObj = queue.remove();
		}
		if (requestObj == null)
			return;
		final RequestObject<?> _requestObj = requestObj;
		HttpClient client = new DefaultHttpClient();
		HttpPost request = new HttpPost(requestObj.getUrl());
		try {
			buildRequest(requestObj, request);
			HttpResponse response = client.execute(request);
			StatusLine status = response.getStatusLine();
			if (status.getStatusCode() != 200) {
				throw new RuntimeException("HTTP Request Error: "
						+ status.getStatusCode() + " - "
						+ status.getReasonPhrase());
			}
			InputStream in = response.getEntity().getContent();
			StringBuilder collector = new StringBuilder();
			byte buffer[] = new byte[1000];
			int inLen;
			Header charSetHeader = response.getEntity().getContentEncoding();
			String charSet = charSetHeader == null ? "UTF-8" : charSetHeader
					.getValue();
			while (0 < (inLen = in.read(buffer))) {
				collector.append(new String(buffer, 0, inLen, charSet));
			}
			final String result = collector.toString();
			runOnMainThread(new Runnable() {
				@Override
				public void run() {
					_requestObj.onSuccess(result);
				}
			});
		} catch (final Exception e) {
			runOnMainThread(new Runnable() {
				@Override
				public void run() {
					_requestObj.onFail(e.getMessage());
				}
			});
		}
	}

	private static void runOnMainThread(Runnable run) {
		Message msg = new Message();
		msg.obj = run;
		mainThread.sendMessage(msg);
	}

	private static Handler mainThread = new Handler() {
		public void handleMessage(Message msg) {
			if (msg.obj instanceof Runnable) {
				((Runnable) msg.obj).run();
			}
		}
	};

}
