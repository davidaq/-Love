package cc.ccme.love;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity extends FragmentActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContent();		
		initView();
		initData();
	}
	
	protected abstract void setContent();
	
	protected abstract void initView();
	
	protected abstract void initData();
	
	protected void startActivity(Context context,Class<?> target)
	{
		Intent intent = new Intent(context,target);
		startActivity(intent);
	}
	
	

}
