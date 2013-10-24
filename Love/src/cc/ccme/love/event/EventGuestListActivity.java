package cc.ccme.love.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;


public class EventGuestListActivity extends BaseActivity implements OnClickListener {

	private ImageButton btnBack;
	@SuppressWarnings("unused")
	private TextView titleText,joinText;
	private ListView listView;
	private GuestAdapter adapter;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_event_guest_list);
		
	}

	@Override
	protected void initView() {
		btnBack  = (ImageButton) findViewById(R.id.btn_back);
		titleText = (TextView) findViewById(R.id.title_text);
		joinText = (TextView) findViewById(R.id.text_join);
		listView = (ListView) findViewById(R.id.listview);
		
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		joinText.setOnClickListener(this);
		
		adapter = new GuestAdapter();
		listView.setAdapter(adapter);
		
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.text_join:
			break;
		}
		
	}

	class GuestAdapter extends BaseAdapter
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
		public View getView(int position, View convertView, ViewGroup arg2) {
			ViewHolder holder;
			if(convertView == null)
			{
				holder = new ViewHolder();
				convertView = getLayoutInflater().inflate(
						R.layout.list_item_guest_list, null);
				holder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
				holder.name = (TextView) convertView.findViewById(R.id.name);
				holder.signature = (TextView) convertView.findViewById(R.id.signature);
				holder.date = (TextView) convertView.findViewById(R.id.date);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			return convertView;
		}
		
	}
	
	class ViewHolder
	{
		ImageView avatar;
		TextView name,signature,date;
	}


}
