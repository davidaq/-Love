package cc.ccme.love.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;

public class LocalAlbumPickFragment extends BaseFragment implements OnClickListener{

	private RelativeLayout layoutImage,layoutVideo;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_video_album_pick_local, null);
		layoutImage = (RelativeLayout) view.findViewById(R.id.relative_image);
		layoutVideo = (RelativeLayout) view.findViewById(R.id.relative_video);
		layoutImage.setOnClickListener(this);
		layoutVideo.setOnClickListener(this);
		return view;
	}
	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.relative_image:
			startActivity(ImagePickActivity.class);
			break;
		case R.id.relative_video:
			startActivity(VideoPickActivity.class);
			break;
		}
		
		
	}
	
	
	

}
