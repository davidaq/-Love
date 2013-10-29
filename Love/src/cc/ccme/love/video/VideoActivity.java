package cc.ccme.love.video;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.widget.FixedGridView;


public class VideoActivity extends BaseActivity implements OnClickListener {

	private ImageButton btnBack,btnOk;
	private LinearLayout btnAdd;
	private ListView listView;
	private MomentAdapter adapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_video);
		
		
	}

	@Override
	protected void initView() {		
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnOk = (ImageButton) findViewById(R.id.btn_ok);
		btnAdd = (LinearLayout) findViewById(R.id.btn_add_moment);
		listView = (ListView) findViewById(R.id.listview);
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnOk.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		adapter = new MomentAdapter();
		listView.setAdapter(adapter);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_ok:
			break;
		case R.id.btn_add_moment:
			break;
		}
		
	}

	class MomentAdapter extends BaseAdapter
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
			if(convertView == null)
			{
				holder = new ViewHolder();
				convertView = getLayoutInflater().inflate(R.layout.list_item_video, null);
				holder.edit = (EditText) convertView.findViewById(R.id.edit_title);
				holder.gridView = (FixedGridView) convertView.findViewById(R.id.gridview);
				convertView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder) convertView.getTag();
			}
			
			VideoAdapter videoAdapter = new VideoAdapter(VideoActivity.this);
			holder.gridView.setAdapter(videoAdapter);
			return convertView;
		}
		
	}
	
	class ViewHolder 
	{
		public EditText edit;
		public FixedGridView gridView;
	}

}
