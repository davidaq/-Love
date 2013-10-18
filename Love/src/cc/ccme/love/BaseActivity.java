package cc.ccme.love;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class BaseActivity extends Activity{
	
	protected void startActivity(Context context,Class<?> target)
	{
		Intent intent = new Intent(context,target);
		startActivity(intent);
	}

}
