package cc.ccme.love;

import cc.ccme.love.MainActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class BaseFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	protected void leftToggle()
	{
		MainActivity.menuLeft.toggle();
	}
	
	protected void rightToggle()
	{
		MainActivity.menuRight.toggle();
	}
	
	protected void startActivity(Class<?> targetClass)
	{
		Intent intent = new Intent(getActivity(),targetClass);
		getActivity().startActivity(intent);
	}

}
