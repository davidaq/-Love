package cc.ccme.love.fragment;

import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.broadcast.BroadcastCommentActivity;
import cc.ccme.love.widget.Player;
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

public class BroadcastFragment extends BaseFragment implements OnClickListener {

    private XListView listView;
    private BroadcastAdapter adapter;
    private ImageButton btnLeftMenu,btnContact;
    public BroadcastFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_broadcast, null);
        initView(view);
        initData();
        listView.setPullLoadEnable(true);
        listView.setPullRefreshEnable(true);
        
        listView.setAdapter(adapter);

        
        
        return view;
    }
    
    private void initData()
    {
    	adapter = new BroadcastAdapter();
    	btnLeftMenu.setOnClickListener(this);
    	btnContact.setOnClickListener(this);
    }

    private void initView(View view)
    {
    	listView = (XListView) view.findViewById(R.id.listview_boradcast);
    	btnLeftMenu = (ImageButton) view.findViewById(R.id.btn_left_menu);
    	btnContact = (ImageButton) view.findViewById(R.id.btn_contact);
    }
    
    class BroadcastAdapter extends BaseAdapter
    {

		@Override
		public int getCount() {
			
			return 20;
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
		public View getView(int arg0, View convertView, ViewGroup arg2) {
			ViewHolder holder;
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_broadcast, null);
				holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
				holder.videoName = (TextView) convertView.findViewById(R.id.video_name);
				holder.soundName = (TextView) convertView.findViewById(R.id.sound_name);
				holder.timeStamp = (TextView) convertView.findViewById(R.id.timestamp);
				holder.btnComment = (ImageButton) convertView.findViewById(R.id.btn_favor);
				holder.btnFavor = (ImageButton) convertView.findViewById(R.id.btn_comment);
				holder.btnShare = (ImageButton) convertView.findViewById(R.id.btn_share);
				holder.commentCount = (TextView) convertView.findViewById(R.id.text_comment_count);
				holder.favorCount = (TextView) convertView.findViewById(R.id.text_favor_count);
				holder.player = (Player) convertView.findViewById(R.id.player);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			holder.player.setResource("http://oss.ccme.cc/db3f58e9-306e-48af-9c90-1bb1fb373e58_fit.mp4");
			holder.btnComment.setOnClickListener(new OnClickListener()
			{

				@Override
				public void onClick(View arg0) {
					startActivity(BroadcastCommentActivity.class);
					
				}
				
			});
			return convertView;
		}
    	
    }
    
    class ViewHolder
    {
    	public ImageView avatar;
    	public Player player;
    	public TextView videoName,soundName,timeStamp;
    	public ImageButton btnComment,btnShare,btnFavor;
    	public TextView commentCount,favorCount;
    }

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btn_left_menu:
			leftToggle();
			break;
		case R.id.btn_contact:
			rightToggle();
			break;
		}
		
	}
}
