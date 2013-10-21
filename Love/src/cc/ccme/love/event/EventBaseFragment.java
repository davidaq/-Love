package cc.ccme.love.event;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;

public class EventBaseFragment extends BaseFragment{
	
	private ListView listView;
	private EventAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_event_organized, null);
		listView = (ListView) view.findViewById(R.id.listview);
		adapter = new EventAdapter();
		listView.setAdapter(adapter);
        return view;
	}

	class EventAdapter extends BaseAdapter
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
			if(convertView==null)
			{
				holder = new ViewHolder();
				convertView = getActivity().getLayoutInflater().inflate(
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
}
