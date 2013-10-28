package cc.ccme.love.album;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class AlbumContentActivity extends BaseActivity implements
		OnClickListener, OnItemClickListener {

	private ImageButton btnBack, btnAdd;
	private TextView titleText;
	private GridView gridView;
	private AlbumContentAdapter adapter;

	@Override
	protected void setContent() {
		setContentView(R.layout.activity_album_content);

	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnAdd = (ImageButton) findViewById(R.id.btn_add);
		titleText = (TextView) findViewById(R.id.title_text);
		gridView = (GridView) findViewById(R.id.gridview);

	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
		titleText.setOnClickListener(this);
		adapter = new AlbumContentAdapter();
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_add:
			break;
		}

	}

	class AlbumContentAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return 52;
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
						R.layout.grid_item_album_content, null);
				holder.image = (ImageView) convertView.findViewById(R.id.image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}

	}

	class ViewHolder {
		public ImageView image;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		startActivity(this,AlbumGalleryActivity.class);
		
	}

}
