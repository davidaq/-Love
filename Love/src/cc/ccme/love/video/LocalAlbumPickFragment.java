package cc.ccme.love.video;

import java.io.File;
import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.video.Constant.ImageFolderInfo;

public class LocalAlbumPickFragment extends BaseFragment{

	private ListView listView;
	private LocalAlbumAdapter adapter;
	private final static int UPDATELIST = 0;
	private final static long fileLimit = 102400;
	private ArrayList<ImageFolderInfo> folderList; 
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_video_album_pick_local, null);
		
		initView(view);
		initData();
		return view;
	}
	
	private void initView(View view)
	{
		listView = (ListView) view.findViewById(R.id.listview);
	}
	
	private void initData()
	{
		folderList = new ArrayList<ImageFolderInfo>();
		adapter = new LocalAlbumAdapter();
		listView.setAdapter(adapter);
		new ScanThread().start();
	}
	
	private class ScanThread extends Thread {
		@Override
		public void run() {
			final String mCardPath = Environment.getExternalStorageDirectory().getPath();
			getFiles(mCardPath);
		}
	}
	@SuppressLint("HandlerLeak")
	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case UPDATELIST:
					folderList.add((ImageFolderInfo) msg.obj);
					adapter.notifyDataSetChanged();
					break;
			}
		}
		
	};

	@SuppressLint("DefaultLocale")
	@SuppressWarnings("deprecation")
	private void getFiles(String path) {
		File f = new File(path);
		File[] files = f.listFiles();
		ImageFolderInfo ifi = new ImageFolderInfo();
		ifi.path = path;
		if (files != null) {
			for (int i = 0; i < files.length; i++) {
				final File ff = files[i];
				if (ff.isDirectory()) {
					getFiles(ff.getPath());
				} else {
					String fName = ff.getName();
					if (fName.indexOf(".") > -1) {
						String end = fName.substring(fName.lastIndexOf(".") + 1, fName.length()).toUpperCase();
						if (Constant.getExtens().contains(end)&&ff.length() > fileLimit) {							
							ifi.filePathes.add(ff.getPath());
						}
					}
				}
			}
		}
		if (!ifi.filePathes.isEmpty()) {
			ifi.pisNum = ifi.filePathes.size();
			String imagePath = ifi.filePathes.get(0);
			BitmapFactory.Options options = new BitmapFactory.Options();
			options.inSampleSize = 2;
			Bitmap bm = BitmapFactory.decodeFile(imagePath, options);
			ifi.image = new BitmapDrawable(bm);
			Message msg = new Message();
			msg.what = UPDATELIST;
			msg.obj = ifi;
			mHandler.sendMessage(msg);
		}
	}
	
	
	class LocalAlbumAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			
			return folderList.size();
		}

		@Override
		public Object getItem(int arg0) {
			
			return null;
		}

		@Override
		public long getItemId(int arg0) {
			
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup arg2) {
			ViewHolder holder;
			if(convertView==null)
			{
				holder = new ViewHolder();
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_video_album_pick_local, null);
				holder.title = (TextView) convertView.findViewById(R.id.title);
				holder.image = (ImageView) convertView.findViewById(R.id.image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			ImageFolderInfo info = folderList.get(position);
			File file = new File(info.path);
			holder.title.setText(file.getName()+"  ( "+info.pisNum+" ) ");
			holder.image.setImageDrawable(info.image);
			return convertView;
		}
		
	}
	
	class ViewHolder 
	{
		public TextView title;
		public ImageView image;
	}
	

}
