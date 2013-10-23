package cc.ccme.love.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.util.Utility;
import cc.ccme.widget.HorizontalListView;

public class EventDetailActivity extends BaseActivity implements OnClickListener, OnItemClickListener {

	private ImageButton btnBack,btnEdit,btnAdd,btnDialog;
	private TextView textJoin;
	private ListView listView;
	private ActivityAdapter adapter;
	private ScrollView scrollView; 
	private HorizontalListView albumListView;
	private AlbumAdapter albumAdapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_event_detail);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnEdit = (ImageButton) findViewById(R.id.btn_edit);
		textJoin = (TextView) findViewById(R.id.text_joiner);
		btnAdd = (ImageButton) findViewById(R.id.btn_add);
		btnDialog = (ImageButton) findViewById(R.id.btn_dialog);
		listView = (ListView) findViewById(R.id.listview);
		scrollView = (ScrollView) findViewById(R.id.scroll_view);
		albumListView = (HorizontalListView) findViewById(R.id.album_list_view);
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnAdd.setOnClickListener(this); 
		btnDialog.setOnClickListener(this);
		textJoin.setOnClickListener(this);
		
		adapter = new ActivityAdapter();
		listView.setAdapter(adapter);
		Utility.setListViewHeightBasedOnChildren(listView);
		listView.setOnItemClickListener(this);
		albumAdapter = new AlbumAdapter();
		albumListView.setAdapter(albumAdapter);
		//scroll to top at init state
		scrollView.post(new Runnable()
		{
			@Override
			public void run() {
				scrollView.scrollTo(0, 0);
				
			}
			
		});
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_edit:
			break;
		case R.id.btn_add:
			break;
		case R.id.btn_dialog:
			break;
		case R.id.text_joiner:
			break;
		}
		
	}
	
	class ActivityAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			return 5;
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
			if(convertView==null)
			{
				holder = new ViewHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.list_item_event_base, null);
				holder.title = (TextView) convertView.findViewById(R.id.event_title);
				holder.privacy = (TextView) convertView.findViewById(R.id.event_privacy);
				holder.date = (TextView) convertView.findViewById(R.id.event_date);
				holder.location = (TextView) convertView.findViewById(R.id.event_location);
				holder.hostFirst = (TextView) convertView.findViewById(R.id.host_first);
				holder.hostSecond = (TextView) convertView.findViewById(R.id.host_second);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}
		
	}
	
	class ViewHolder 
	{
		public TextView title,privacy,date,location,hostFirst,hostSecond;
	}
	
	class AlbumAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			return 6;
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
			AlbumHolder holder;
			if(convertView==null)
			{
				holder = new AlbumHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.list_item_event_detail_album, null);
				holder.image = (ImageView) convertView.findViewById(R.id.image);

				convertView.setTag(holder);
			} else {
				holder = (AlbumHolder) convertView.getTag();
			}
			return convertView;
		}
		
	}
	
	class AlbumHolder
	{
		public ImageView image;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		
		
	}


}
