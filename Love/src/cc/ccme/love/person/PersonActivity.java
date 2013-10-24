package cc.ccme.love.person;

import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PersonActivity extends BaseActivity implements OnClickListener {

	private ImageButton btnBack,btnSettings,btnShareSina,btnShareMm;
	@SuppressWarnings("unused")
	private TextView titleText;
	@SuppressWarnings("unused")
	private ImageView avatar;
	@SuppressWarnings("unused")
	private TextView userName,signature,age,attentionCount,fansCount;
	private Button btnAlbum,btnEvent;
	
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_person);		
	}
	
	protected void initView()
	{
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnSettings = (ImageButton) findViewById(R.id.btn_settings);
		btnShareSina = (ImageButton) findViewById(R.id.btn_share_sina);
		btnShareMm = (ImageButton) findViewById(R.id.btn_share_mm);
		
		titleText = (TextView) findViewById(R.id.title_text);
		avatar = (ImageView) findViewById(R.id.avatar);
		
		userName = (TextView) findViewById(R.id.username);
    	signature = (TextView) findViewById(R.id.signature);
    	age = (TextView) findViewById(R.id.age);
    	attentionCount = (TextView) findViewById(R.id.attention_count);
    	fansCount = (TextView) findViewById(R.id.fans_count);
    	
    	btnAlbum = (Button) findViewById(R.id.btn_album);
    	btnEvent = (Button) findViewById(R.id.btn_event);
    	
    	
	}


	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
    	btnSettings.setOnClickListener(this);
    	btnShareSina.setOnClickListener(this);
    	btnShareMm.setOnClickListener(this);
    	btnAlbum.setOnClickListener(this);
    	btnEvent.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_settings:
			startActivity(this,PersonEditActivity.class);
			break;
		case R.id.btn_share_sina:
			break;
		case R.id.btn_share_mm:
			break;
		case R.id.btn_album:
			break;
		case R.id.btn_event:
			break;
			
		}
		
	}



}
