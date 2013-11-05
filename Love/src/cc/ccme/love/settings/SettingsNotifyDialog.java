package cc.ccme.love.settings;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import cc.ccme.love.R;

public class SettingsNotifyDialog extends Dialog implements android.view.View.OnClickListener{
	private RadioButton btnRing,btnQuake,btnNone;
	public SettingsNotifyDialog(Context context) {
		super(context,R.style.BaseDialog);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_notify);
		btnRing = (RadioButton) findViewById(R.id.radio_ring);
		btnQuake = (RadioButton) findViewById(R.id.radio_quake);
		btnNone = (RadioButton) findViewById(R.id.radio_none);
		btnRing.setOnClickListener(this);
		btnQuake.setOnClickListener(this);
		btnNone.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.radio_ring:
			break;
		case R.id.radio_quake:
			break;
		case R.id.radio_none:
			break;
		}
		dismiss();
	}

}
