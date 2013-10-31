package cc.ccme.love.video;

import cc.ccme.love.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AlbumListAdapter extends BaseAdapter {

	private Context context;

	public AlbumListAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {

		return 4;
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
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(
					R.layout.list_item_video_album_pick_love_content, null);
			holder.title = (TextView) convertView
					.findViewById(R.id.event_title);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		return convertView;
	}

	class ViewHolder {
		public TextView title;
		public ImageView image;
	}
}
