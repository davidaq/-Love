package cc.ccme.love.video;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TabHost;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class VideoImagePickActivity extends BaseActivity implements OnClickListener{

	private TabHost tabHost;
	private ImageButton btnBack,btnOk;
	private View tabSelectorLove,tabSelectorLocal;
	public static  VideoImagePickActivity instance = null;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_video_image_pick);
		instance = this;
	}

	@Override
	protected void initView() {
		LayoutInflater mInflater = LayoutInflater.from(this); 
        tabSelectorLove = mInflater.inflate(R.layout.tabselector_event_love, null);
		tabSelectorLocal = mInflater.inflate(R.layout.tabselector_video_local, null);
		tabHost = (TabHost) findViewById(android.R.id.tabhost);	
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnOk = (ImageButton) findViewById(R.id.btn_ok);
		
	}

	@Override
	protected void initData() {
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("love").setIndicator(tabSelectorLove).setContent(R.id.album_love));
		tabHost.addTab(tabHost.newTabSpec("local").setIndicator(tabSelectorLocal).setContent(R.id.album_local));
		btnBack.setOnClickListener(this);
		btnOk.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_ok:
			break;
		}
		
		
	}
	

}
