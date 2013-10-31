package cc.ccme.love.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.event.EventDetailActivity;
import cc.ccme.love.widget.FixedListView;

public class LoveAlbumPickFragment extends BaseFragment implements OnItemClickListener{

	private ListView listView;
	
	private AlbumPickAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_video_album_pick_love, null);
		listView = (ListView) view.findViewById(R.id.listview);
		
		listView.setOnItemClickListener(this);
		
		adapter = new AlbumPickAdapter();
		listView.setAdapter(adapter);
		return view;
	}
	
	class AlbumPickAdapter extends BaseAdapter
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
				convertView = getActivity().getLayoutInflater().inflate(
						R.layout.list_item_video_album_pick_love, null);
				holder.title = (TextView) convertView.findViewById(R.id.title);
				holder.listView = (FixedListView) convertView.findViewById(R.id.listview);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}
			AlbumListAdapter albumListAdapter  = new AlbumListAdapter(getActivity());
			holder.listView.setAdapter(albumListAdapter);
			return convertView;
		}
		
	}
	
	class ViewHolder 
	{
		public TextView title;
		public FixedListView listView;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		startActivity(EventDetailActivity.class);		
	}

	
}
