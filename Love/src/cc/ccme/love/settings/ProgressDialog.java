package cc.ccme.love.settings;

import cc.ccme.love.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

public class ProgressDialog extends Dialog{

	public ProgressDialog(Context context) {
		super(context,R.style.BaseDialog);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_progress);
	}

}
