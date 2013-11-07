package cc.ccme.love.fragment;

import java.util.ArrayList;
import java.util.Arrays;
import bean.VideoFlowExt;
import service.VideoFlowAction.OnGetVideoListForNoLoginSuccessListener;
import util.OnRequestFailListener;
import util.RequestObject;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.broadcast.BroadcastCommentActivity;
import cc.ccme.love.util.DateUtil;
import cc.ccme.love.util.ImageManager;
import cc.ccme.love.util.ParseUtil;
import cc.ccme.love.widget.Player;
import cc.ccme.love.widget.Player.OnFullScreenListener;
import cc.ccme.love.widget.XListView;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class BroadcastFragment extends BaseFragment implements OnClickListener,
		OnGetVideoListForNoLoginSuccessListener, OnRequestFailListener {

	private XListView listView;
	private BroadcastAdapter adapter;
	private ImageButton btnLeftMenu, btnContact;
	private ArrayList<VideoFlowExt> videoList;
	private ImageManager manager;

	public BroadcastFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_broadcast, null);
		initView(view);
		initData();
		listView.setPullLoadEnable(true);
		listView.setPullRefreshEnable(true);

		listView.setAdapter(adapter);

		return view;
	}

	private void initData() {
		manager = ImageManager.from(getActivity());
		videoList = new ArrayList<VideoFlowExt>();
		adapter = new BroadcastAdapter();
		btnLeftMenu.setOnClickListener(this);
		btnContact.setOnClickListener(this);

		service.VideoFlowAction
				.getVideoListForNoLogin(System.currentTimeMillis())
				.onSuccess(this).onFail(this);
	}

	private void initView(View view) {
		listView = (XListView) view.findViewById(R.id.listview_boradcast);
		btnLeftMenu = (ImageButton) view.findViewById(R.id.btn_left_menu);
		btnContact = (ImageButton) view.findViewById(R.id.btn_contact);
	}

	class BroadcastAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return videoList.size();
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
			final ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_broadcast, null);
				holder.avatar = (ImageView) convertView
						.findViewById(R.id.avatar);
				holder.videoName = (TextView) convertView
						.findViewById(R.id.video_name);
				holder.soundName = (TextView) convertView
						.findViewById(R.id.sound_name);
				holder.timeStamp = (TextView) convertView
						.findViewById(R.id.timestamp);
				holder.btnComment = (ImageButton) convertView
						.findViewById(R.id.btn_comment);
				holder.btnFavor = (ImageButton) convertView
						.findViewById(R.id.btn_favor);
				holder.btnShare = (ImageButton) convertView
						.findViewById(R.id.btn_share);
				holder.commentCount = (TextView) convertView
						.findViewById(R.id.text_comment_count);
				holder.favorCount = (TextView) convertView
						.findViewById(R.id.text_favor_count);
				holder.player = (Player) convertView.findViewById(R.id.player);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			VideoFlowExt video = videoList.get(position);
			manager.displayImage(holder.avatar,
					ParseUtil.parseImageFit(video.headerPic), 0);
			holder.videoName.setText(video.videoName);
			holder.soundName.setText(video.musicName);
			holder.timeStamp.setText(DateUtil.dateToString(video.timeStamp));
			holder.commentCount.setText(video.reviewCount.toString());
			holder.favorCount.setText(video.praiseCount.toString());
			holder.player.setFlieList(video.picFileList);
			holder.player.startSwitch();
			holder.player.setResource(ParseUtil.parseVideoFit(video.videoId));
			holder.player.setOnFullScreenListener(new OnFullScreenListener() {
				@Override
				public void onFullScreen() {
					
				}

				@Override
				public void onResume() {

				}

			});
			holder.btnComment.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					startActivity(BroadcastCommentActivity.class);

				}

			});
			return convertView;
		}

	}

	class ViewHolder {
		public ImageView avatar;
		public Player player;
		public TextView videoName, soundName, timeStamp;
		public ImageButton btnComment, btnShare, btnFavor;
		public TextView commentCount, favorCount;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_left_menu:
			leftToggle();
			break;
		case R.id.btn_contact:
			rightToggle();
			break;
		}

	}

	@Override
	public void onGetVideoListForNoLoginSuccess(VideoFlowExt[] result) {
		videoList = new ArrayList<VideoFlowExt>(Arrays.asList(result));
		System.out.println(videoList.size());
		adapter.notifyDataSetChanged();

	}

	@Override
	public void onRequestFail(RequestObject<?> request, String message) {
		System.out.println(message);

	}
}
