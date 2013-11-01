package cc.ccme.love.video;

import cc.ccme.love.util.FileUtil;
import android.provider.MediaStore;
import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Bitmap;

public class VideoPickActivity extends VideoImageSelectBaseActivity {
	
	private Bitmap getThumbnail(String path, int width, int height) {
		return FileUtil.getVideoThumbnail(VideoPickActivity.this,path, width, height);
	}

	@Override
	protected Bitmap getBitmap(String url) {
		return getThumbnail(url,size,size);
	}

	@Override
	protected Cursor getCursor() {
		ContentResolver cr = VideoPickActivity.this.getContentResolver();
		Cursor cur = cr.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
				columns, null, null, null);
		return cur;
	}

	

}
