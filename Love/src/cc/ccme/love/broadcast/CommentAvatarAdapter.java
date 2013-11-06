package cc.ccme.love.broadcast;

import cc.ccme.love.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class CommentAvatarAdapter extends BaseAdapter{

	private Context context;
	public CommentAvatarAdapter (Context context)
	{
		this.context = context;
	}
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
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = LayoutInflater.from(context);
			convertView = inflater.inflate(
					R.layout.list_item_comment_avatar, null);
			holder.image = (ImageView) convertView.findViewById(R.id.image);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		return convertView;
	}

	class ViewHolder {
		public ImageView image;
	}
}
