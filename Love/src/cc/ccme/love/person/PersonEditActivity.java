package cc.ccme.love.person;

import java.io.File;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import cc.ccme.love.util.ImageUtil;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class PersonEditActivity extends BaseActivity implements OnClickListener {

	private ImageView avatar,background;
	private File sdcardTempFile;
	private ImageButton btnBack;
	private static int CODE_AVATAR = 30;
	private static int CODE_BACK = 40;

	@Override
	protected void setContent() {
		setContentView(R.layout.activity_person_edit);
	}
	
	@Override
	protected void initView() {
		avatar = (ImageView) findViewById(R.id.avatar);	
		background = (ImageView) findViewById(R.id.background);
		btnBack = (ImageButton) findViewById(R.id.btn_back);
	}

	@Override
	protected void initData() {
		avatar.setOnClickListener(this);
		background.setOnClickListener(this);
		btnBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.avatar:
			sdcardTempFile = new File(Environment.getExternalStorageDirectory()+"/tmp/", "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg");
			Intent intent = new Intent("android.intent.action.PICK");
            intent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
            intent.putExtra("output", Uri.fromFile(sdcardTempFile));
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 200);
            intent.putExtra("outputY", 200);
            startActivityForResult(intent, CODE_AVATAR);
			break;
		case R.id.background:
			sdcardTempFile = new File(Environment.getExternalStorageDirectory()+"/tmp/", "tmp_pic_" + SystemClock.currentThreadTimeMillis() + ".jpg");
			Intent mIntent = new Intent("android.intent.action.PICK");
			mIntent.setDataAndType(MediaStore.Images.Media.INTERNAL_CONTENT_URI, "image/*");
			mIntent.putExtra("output", Uri.fromFile(sdcardTempFile));
			mIntent.putExtra("crop", "true");
			mIntent.putExtra("aspectX", 1);
			mIntent.putExtra("aspectY", 1);
			mIntent.putExtra("outputX", 500);
			mIntent.putExtra("outputY", 500);
            startActivityForResult(mIntent, CODE_BACK);
			break;
		case R.id.btn_back:
			finish();
			break;
			
		}
		
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK ) {
			if(requestCode == CODE_AVATAR)
			{
	            Bitmap bmp = BitmapFactory.decodeFile(sdcardTempFile.getAbsolutePath());
	            avatar.setImageBitmap(ImageUtil.toRoundBitmap(bmp));
			}
			else if(requestCode == CODE_BACK)
			{
				Bitmap bmp = BitmapFactory.decodeFile(sdcardTempFile.getAbsolutePath());
	            background.setImageBitmap(bmp);
			}
	        }

	}
	

}
