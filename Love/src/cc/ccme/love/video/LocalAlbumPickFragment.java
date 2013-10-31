package cc.ccme.love.video;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;

public class LocalAlbumPickFragment extends BaseFragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_album_pick_love, null);
		return view;
	}
	

}
