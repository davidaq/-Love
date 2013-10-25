package cc.ccme.love.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class GalleryActivity extends BaseActivity implements OnClickListener, OnItemClickListener {

	private ImageButton btnBack;
	private ListView listView;
	private AlbumAdapter adapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_gallery);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		listView = (ListView) findViewById(R.id.listview);
		
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		adapter = new AlbumAdapter();
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
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

	class AlbumAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			
			return 10;
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
				convertView = getLayoutInflater().inflate(
						R.layout.list_item_gallery, null);
				holder.cover = (ImageView) convertView.findViewById(R.id.album_cover);
				holder.title = (TextView) convertView.findViewById(R.id.album_title);
				holder.name = (TextView) convertView.findViewById(R.id.album_name);
				holder.date = (TextView) convertView.findViewById(R.id.album_date);
				holder.count = (TextView) convertView.findViewById(R.id.album_count);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}
		
	}

	class ViewHolder 
	{
		public TextView title,name,date,count;
		public ImageView cover;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		
		startActivity(this,AlbumActivity.class);
	}

}
