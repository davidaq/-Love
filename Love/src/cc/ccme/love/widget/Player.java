package cc.ccme.love.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import cc.ccme.love.R;
import cc.ccme.love.util.ImageManager;
import cc.ccme.love.util.ParseUtil;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

@SuppressLint("HandlerLeak")
public class Player extends RelativeLayout {

	private LoveVideoView videoView;
	private ToggleButton btnPlay, btnZoom;
	private ImageView cover;
	private String url;
	private OnFullScreenListener listener;
	private ArrayList<String> picList;
	private boolean hasPlayed = false;
	private Context context;
	private Timer mTimer;
	private ImageManager manager;
	private int currentItem = 0;
	private int totalItem = 0;
	

	public Player(Context context) {
		this(context, null);

	}

	public Player(Context context, AttributeSet attrs) {
		this(context, attrs, 0);

	}

	public Player(final Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		View view = View.inflate(context, R.layout.widget_player, null);
		this.addView(view);
		picList = new ArrayList<String>();
		manager = ImageManager.from(context);
		btnPlay = (ToggleButton) view.findViewById(R.id.btn_play);
		btnZoom = (ToggleButton) view.findViewById(R.id.btn_zoom);
		videoView = (LoveVideoView) view.findViewById(R.id.video_view);
		cover = (ImageView) view.findViewById(R.id.cover);

		btnPlay.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isPaused) {
				if (!isPaused) {
					pause();
				} else {
					start();
				}

			}

		});
		btnZoom.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isWindow) {
				if (isWindow) {
					listener.onFullScreen();
				} else {
					listener.onResume();
				}

			}

		});
	}

	public Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			manager.displayImage(cover, ParseUtil.parseImageFit(picList.get(currentItem)), 0);
		}
	};

	public void setResource(String url) {
		this.url = url;
	}

	public void pause() {
		videoView.pause();
	}

	public void seekTo(int msec) {
		videoView.seekTo(msec);
	}

	public void stop() {
		videoView.destroyDrawingCache();
		videoView.stopPlayback();
	}

	public void start() {
		stopSwitch();
		if (!hasPlayed) {
			MediaController mc = new MediaController(context);
			mc.setVisibility(View.GONE);
			videoView.setMediaController(mc);
			Uri uri = Uri.parse(url);
			videoView.setVideoURI(uri);

		}
		videoView.start();
		videoView.requestFocus();
		hasPlayed = true;
	}

	public int getLength() {
		return videoView.getDuration();
	}

	public void setFlieList(List<String> list) {
		this.picList = (ArrayList<String>) list;
		totalItem = list.size() - 1;
	}

	public void startSwitch() {
		mTimer = new Timer();
		mTimer.schedule(new TimerTask() {
			@Override
			public void run() {
				mHandler.sendEmptyMessage(0);
				if(currentItem<totalItem)
					currentItem++;
				else
					currentItem = 0;
			}
		}, 0 * 1000, 3 * 1000);
	}
	
	public void stopSwitch()
	{		
		mTimer.cancel();
		cover.setVisibility(View.GONE);
	}

	public interface OnFullScreenListener {
		public void onFullScreen();

		public void onResume();
	}

	public void setOnFullScreenListener(OnFullScreenListener listener) {
		this.listener = listener;
	}

}
