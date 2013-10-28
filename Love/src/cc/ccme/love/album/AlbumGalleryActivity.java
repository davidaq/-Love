package cc.ccme.love.album;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.truba.touchgallery.GalleryWidget.GalleryViewPager;
import ru.truba.touchgallery.GalleryWidget.UrlPagerAdapter;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class AlbumGalleryActivity extends BaseActivity implements OnClickListener {


	private ImageButton btnBack,btnEdit,btnComment,btnFavor,btnShare;
	private GalleryViewPager gallery;
	private RelativeLayout titleBar,bottomBar;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_album_gallery);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnEdit = (ImageButton) findViewById(R.id.btn_edit);
		btnComment = (ImageButton) findViewById(R.id.btn_comment);
		btnFavor = (ImageButton) findViewById(R.id.btn_favor);
		btnShare = (ImageButton) findViewById(R.id.btn_share);
		gallery = (GalleryViewPager) findViewById(R.id.gallery);
		titleBar = (RelativeLayout) findViewById(R.id.title_bar);
		bottomBar = (RelativeLayout) findViewById(R.id.bottom_bar);
		
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnEdit.setOnClickListener(this);
		btnComment.setOnClickListener(this);
		btnFavor.setOnClickListener(this);
		btnShare.setOnClickListener(this);
		String[] urls = {
				"http://g.hiphotos.baidu.com/pic/w%3D230/sign=34c3f48f908fa0ec7fc7630e1696594a/c8ea15ce36d3d539e013397f3b87e950352ab05b.jpg",
				"http://h.hiphotos.baidu.com/pic/w%3D230/sign=a8a64457a8ec8a13141a50e3c7029157/d52a2834349b033ba43f9c6214ce36d3d439bdd7.jpg",
				"http://e.hiphotos.baidu.com/pic/w%3D230/sign=8dc597dc574e9258a63481edac83d1d1/fd039245d688d43f0372ee4a7c1ed21b0ff43baa.jpg",
				"http://d.hiphotos.baidu.com/pic/w%3D230/sign=a191c6e31f178a82ce3c78a3c602737f/8b13632762d0f703b238a9f309fa513d2697c512.jpg",
				"http://f.hiphotos.baidu.com/pic/w%3D230/sign=2535cad1c2fdfc03e578e4bbe43e87a9/aa64034f78f0f736420a702e0b55b319ebc4132c.jpg",
				"http://c.hiphotos.baidu.com/pic/w%3D230/sign=59a8fcd9f91986184147e8877aec2e69/3c6d55fbb2fb4316879103c221a4462308f7d3f8.jpg",
				"http://f.hiphotos.baidu.com/pic/w%3D230/sign=0bbc9c79b7003af34dbadb63052bc619/9a504fc2d5628535d8b2ae5191ef76c6a7ef636b.jpg",};
		List<String> items = new ArrayList<String>();
		Collections.addAll(items, urls);
		UrlPagerAdapter pagerAdapter = new UrlPagerAdapter(this, items);  
		gallery.setOffscreenPageLimit(3);
		gallery.setAdapter(pagerAdapter);
		gallery.setOnClickListener(this);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_edit:
			AlbumPictureDialog dialog = new AlbumPictureDialog(this);
			dialog.show();
			WindowManager windowManager = getWindowManager();
			Display display = windowManager.getDefaultDisplay();
			WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
			lp.width = (int)(display.getWidth()); //设置宽度
			dialog.getWindow().setAttributes(lp);
			break;
		case R.id.btn_comment:
			break;
		case R.id.btn_favor:
			break;
		case R.id.btn_share:
			break;
		case R.id.gallery:
			titleBar.setVisibility(View.GONE);
			bottomBar.setVisibility(View.GONE);
			break;
		}
		
	}

}
