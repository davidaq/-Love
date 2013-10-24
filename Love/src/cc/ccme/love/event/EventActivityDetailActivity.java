package cc.ccme.love.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.widget.HorizontalListView;

public class EventActivityDetailActivity extends BaseActivity implements OnClickListener, OnItemClickListener {

	private ImageButton btnBack,btnEdit,btnDialog;
	private TextView textJoin; 
	private HorizontalListView albumListView;
	private AlbumAdapter albumAdapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_event_activity_detail);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnEdit = (ImageButton) findViewById(R.id.btn_edit);
		textJoin = (TextView) findViewById(R.id.text_guest);
		btnDialog = (ImageButton) findViewById(R.id.btn_dialog);
		albumListView = (HorizontalListView) findViewById(R.id.album_list_view);
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnDialog.setOnClickListener(this);
		textJoin.setOnClickListener(this);
		
		albumAdapter = new AlbumAdapter();
		albumListView.setAdapter(albumAdapter);
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
		case R.id.btn_dialog:
			startActivity(this,EventDialogActivity.class);
			break;
		case R.id.text_guest:
			startActivity(this,EventGuestListActivity.class);
			break;
		}
		
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
