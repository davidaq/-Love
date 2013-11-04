package cc.ccme.love.congrate;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class CongrateActivity extends BaseActivity implements OnClickListener, OnItemClickListener {

	private ImageButton btnBack;
	private Button btnPost;
	private GridView gridView;
	private CongrateAdapter adapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_congrate);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnPost = (Button) findViewById(R.id.btn_post);
		gridView = (GridView) findViewById(R.id.gridview);
		
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnPost.setOnClickListener(this);
		adapter = new CongrateAdapter();
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
		
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_post:
			startActivity(this,CongratePostActivity.class);
			break;
		}
		
		
	}

	class CongrateAdapter extends BaseAdapter
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
			if (convertView == null) {
				holder = new ViewHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.grid_item_congrate, null);
				holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
				holder.content = (TextView) convertView.findViewById(R.id.content);
				holder.count = (TextView) convertView.findViewById(R.id.text_count);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

	}

	class ViewHolder {
		public ImageView avatar;
		public TextView content,count;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		CongrateDialog dialog = new CongrateDialog(this);
		dialog.show();
		
	}


}
