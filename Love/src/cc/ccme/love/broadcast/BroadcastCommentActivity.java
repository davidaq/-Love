package cc.ccme.love.broadcast;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.widget.HorizontalListView;
import cc.ccme.love.widget.Player;
import cc.ccme.love.widget.XListView;

public class BroadcastCommentActivity extends BaseActivity implements OnClickListener{

	private XListView listview;
	private View headerGood;
	private int headerCount = 3;
	private HorizontalListView hListView;
	private CommentAdapter adapter;
	private ImageButton btnBack;
	private Player player;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_broadcast_comment);
			
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		listview = (XListView) this.findViewById(R.id.listview);
		headerGood = this.getLayoutInflater().inflate(
				R.layout.header_comment_good, null);
		hListView = (HorizontalListView) headerGood.findViewById(R.id.listview);
		player = new Player(this);
	}

	@Override
	protected void initData() {
		player.setResource("http://oss.ccme.cc/db3f58e9-306e-48af-9c90-1bb1fb373e58_fit.mp4");
		btnBack.setOnClickListener(this);
		listview.setPullLoadEnable(true);		
		listview.addHeaderView(player);
		listview.addHeaderView(headerGood);
		adapter = new CommentAdapter();
		listview.setAdapter(adapter);
		//listview.setSelection(headerCount);
		hListView.setAdapter(new CommentAvatarAdapter(this));
		
		
	}
	
	class CommentAdapter extends BaseAdapter {
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
		public View getView(int position, View convertView, ViewGroup arg2) {
			ViewHolder holder;			
			if(convertView == null) 
			{
				holder = new ViewHolder();
				convertView = BroadcastCommentActivity.this.getLayoutInflater().inflate(
						R.layout.list_item_comment, null);
				holder.username = (TextView)convertView.findViewById(R.id.username);
				holder.date = (TextView)convertView.findViewById(R.id.date);
				holder.content = (TextView)convertView.findViewById(R.id.content);
				holder.avatar = (ImageView)convertView.findViewById(R.id.avatar);
				convertView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder)convertView.getTag();
			}

			return convertView;
		}

	}
	
	class ViewHolder 
	{
		ImageView avatar;
		TextView username,date,content;
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		}
		
	}

}
