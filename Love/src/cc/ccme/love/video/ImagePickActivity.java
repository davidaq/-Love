package cc.ccme.love.video;

import cc.ccme.love.util.FileUtil;
import android.provider.MediaStore;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;

public class ImagePickActivity extends VideoImageSelectBaseActivity {

	


	private Bitmap getThumbnail(String path, int width, int height) {
		return FileUtil.getImageThumbnail(path, width, height);
	}

	@Override
	protected Bitmap getBitmap(String url) {
		Bitmap bitmap = getThumbnail(url, size,size);
		return bitmap;
	}

	@Override
	protected Cursor getCursor() {
		ContentResolver cr = ImagePickActivity.this.getContentResolver();
		Cursor cur = cr.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
				columns, null, null, null);
		return cur;
	}




}
