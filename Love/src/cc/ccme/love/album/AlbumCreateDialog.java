package cc.ccme.love.album;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cc.ccme.love.R;

public class AlbumCreateDialog extends Dialog implements android.view.View.OnClickListener{

	private Button btnCancel,btnSave;
	public AlbumCreateDialog(Context context) {
		super(context,R.style.BaseDialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_album_create);
		btnCancel = (Button) findViewById(R.id.btn_cancel);
		btnSave = (Button) findViewById(R.id.btn_save);
		btnCancel.setOnClickListener(this);
		btnSave.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_cancel:
			dismiss();
			break;
		case R.id.btn_save:
			dismiss();
			break;
		}
		
	}


}
