package cc.ccme.love.album;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import cc.ccme.love.R;

public class AlbumPictureDialog extends Dialog implements android.view.View.OnClickListener{

	private LinearLayout btnSave,btnDelete,btnCancel;
	public AlbumPictureDialog(Context context) {
		super(context,R.style.BaseDialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_picture_option);
		Window window = getWindow();
		window.setGravity(Gravity.BOTTOM);
		btnSave = (LinearLayout) findViewById(R.id.btn_save);
		btnDelete = (LinearLayout) findViewById(R.id.btn_delete);
		btnCancel = (LinearLayout) findViewById(R.id.btn_cancel);
		btnSave.setOnClickListener(this);
		btnDelete.setOnClickListener(this);
		btnCancel.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_save:
			break;
		case R.id.btn_delete:
			break;
		case R.id.btn_cancel:
			dismiss();
			break;
		}
		
	}


}
