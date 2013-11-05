package cc.ccme.love.settings;

import cc.ccme.love.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SettingsNewVersionDialog extends Dialog implements android.view.View.OnClickListener{

	private Button btnCancel,btnUpdate;
	public SettingsNewVersionDialog(Context context) {
		super(context,R.style.BaseDialog);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_new_version);
		btnCancel = (Button) findViewById(R.id.btn_cancel);
		btnUpdate = (Button) findViewById(R.id.btn_update);
		btnCancel.setOnClickListener(this);
		btnUpdate.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btn_cancel:
			dismiss();
			break;
		case R.id.btn_update:
			break;
		}
		
	}
}
