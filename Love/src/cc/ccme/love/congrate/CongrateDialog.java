package cc.ccme.love.congrate;

import cc.ccme.love.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class CongrateDialog extends Dialog{

	public CongrateDialog(Context context) {
		super(context,R.style.BaseDialog);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_congrate);
	}

}
