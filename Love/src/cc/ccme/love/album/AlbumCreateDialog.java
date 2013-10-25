package cc.ccme.love.album;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import cc.ccme.love.R;

public class AlbumCreateDialog extends Dialog{

	public AlbumCreateDialog(Context context) {
		super(context,R.style.BaseDialog);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_album_create);
	}


}
