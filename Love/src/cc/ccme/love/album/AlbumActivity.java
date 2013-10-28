package cc.ccme.love.album;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class AlbumActivity extends BaseActivity implements OnClickListener,
		OnCheckedChangeListener, OnItemClickListener {

	private GridView gridView;
	private AlbumAdapter adapter;
	private ToggleButton btnEdit;
	private ImageButton btnBack;
	private boolean isChecked;
	private Button btnCreate;

	@Override
	protected void setContent() {
		setContentView(R.layout.activity_album);

	}

	@Override
	protected void initView() {
		gridView = (GridView) findViewById(R.id.gridview);
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnEdit = (ToggleButton) findViewById(R.id.btn_edit);
		btnCreate = (Button) findViewById(R.id.btn_create);
	}

	@Override
	protected void initData() {
		isChecked = false;
		btnBack.setOnClickListener(this);
		btnCreate.setOnClickListener(this);
		btnEdit.setOnCheckedChangeListener(this);
		adapter = new AlbumAdapter();
		gridView.setAdapter(adapter);
		gridView.setOnItemClickListener(this);

	}

	class AlbumAdapter extends BaseAdapter {

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
						R.layout.grid_item_album, null);
				holder.btnDelete = (ImageButton) convertView
						.findViewById(R.id.btn_delete);
				holder.btnEdit = (ImageButton) convertView
						.findViewById(R.id.btn_edit);
				holder.btnPrivacy = (ToggleButton) convertView
						.findViewById(R.id.btn_privacy);
				holder.cover = (ImageView) convertView
						.findViewById(R.id.image_cover);
				holder.text_title = (TextView) convertView
						.findViewById(R.id.text_title);
				holder.text_privacy = (TextView) convertView
						.findViewById(R.id.text_privacy);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			if (!isChecked) {
				holder.btnDelete.setVisibility(View.INVISIBLE);
				holder.btnPrivacy.setVisibility(View.INVISIBLE);
				holder.btnEdit.setVisibility(View.INVISIBLE);
			} else {
				holder.btnDelete.setVisibility(View.VISIBLE);
				holder.btnPrivacy.setVisibility(View.VISIBLE);
				holder.btnEdit.setVisibility(View.VISIBLE);
			}
			return convertView;
		}

	}

	class ViewHolder {
		public ImageButton btnDelete, btnEdit;
		public ToggleButton btnPrivacy;
		public TextView text_title, text_privacy;
		public ImageView cover;
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_edit:
			break;
		case R.id.btn_create:
			AlbumCreateDialog dialog = new AlbumCreateDialog(this);
			dialog.show();
			btnCreate.setVisibility(View.GONE);
			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean isChecked) {
		this.isChecked = isChecked;
		adapter.notifyDataSetChanged();

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position,
			long arg3) {
		startActivity(this, AlbumContentActivity.class);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_MENU) {
			switch (btnCreate.getVisibility()) {
			case View.VISIBLE:
				btnCreate.setVisibility(View.GONE);
				break;
			case View.GONE:
				btnCreate.setVisibility(View.VISIBLE);
				break;
			}

		} else {
			super.onKeyDown(keyCode, event);
		}
		return true;
	}

}
