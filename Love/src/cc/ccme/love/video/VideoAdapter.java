package cc.ccme.love.video;

import cc.ccme.love.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;

public class VideoAdapter extends BaseAdapter {

	private Context context;
	private int count = 7;

	public VideoAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {

		return count + 1;
	}

	@Override
	public Object getItem(int position) {

		return null;
	}

	@Override
	public long getItemId(int position) {

		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		ViewHolder holder;
		if( position < count )
		{
			if(convertView == null)
			{
				holder = new ViewHolder();
				LayoutInflater inflater = LayoutInflater.from(context);
			    convertView = inflater.inflate(R.layout.grid_item_video, null);
				holder.btnDelete = (ImageButton) convertView.findViewById(R.id.btn_delete);
				holder.image = (ImageView) convertView.findViewById(R.id.image);
				convertView.setTag(holder);
			}
			else
			{
				holder = (ViewHolder) convertView.getTag();
			}
		}
		else
		{
			LayoutInflater inflater = LayoutInflater.from(context);
		    convertView = inflater.inflate(R.layout.grid_item_add, null);
		    ((ImageButton) convertView.findViewById(R.id.btn_add)).setOnClickListener(new OnClickListener()
		    {
				@Override
				public void onClick(View view) {
					System.out.println("button");
					
				}
		    	
		    });
		}
		
		return convertView;
	}

	class ViewHolder {
		public ImageButton btnDelete;
		public ImageView image;
	}

}
