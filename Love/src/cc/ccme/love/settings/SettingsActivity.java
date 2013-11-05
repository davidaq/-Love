package cc.ccme.love.settings;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class SettingsActivity extends BaseActivity implements OnClickListener{

	private ImageButton btnBack;
	@SuppressWarnings("unused")
	private TextView textUpdate,textCache,textNotify;
	private RelativeLayout itemUpdate,itemCache,itemNotify,itemDuty,itemFeedback,itemAbout,itemAbort;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_settings);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		textUpdate = (TextView) findViewById(R.id.text_update);
		textCache = (TextView) findViewById(R.id.text_cache);
		textNotify = (TextView) findViewById(R.id.text_notify);
		itemUpdate = (RelativeLayout) findViewById(R.id.item_update);
		itemCache = (RelativeLayout) findViewById(R.id.item_cache);
		itemNotify = (RelativeLayout) findViewById(R.id.item_notify);
		itemDuty = (RelativeLayout) findViewById(R.id.item_duty);
		itemFeedback = (RelativeLayout) findViewById(R.id.item_feedback);
		itemAbout = (RelativeLayout) findViewById(R.id.item_about);
		itemAbort = (RelativeLayout) findViewById(R.id.item_abort);
		
	}

	@Override
	protected void initData() {
		
		btnBack.setOnClickListener(this);
		itemUpdate.setOnClickListener(this);
		itemCache.setOnClickListener(this);
		itemNotify.setOnClickListener(this);
		itemDuty.setOnClickListener(this);
		itemFeedback.setOnClickListener(this);
		itemAbout.setOnClickListener(this);
		itemAbort.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.item_update:
			SettingsNewVersionDialog dialog = new SettingsNewVersionDialog(this);
			dialog.show();
			break;
		case R.id.item_cache:
			break;
		case R.id.item_notify:
			SettingsNotifyDialog notifyDialog = new SettingsNotifyDialog(this);
			notifyDialog.show();
			break;
		case R.id.item_duty:
			break;
		case R.id.item_about:
			break;
		case R.id.item_feedback:
			break;
		case R.id.item_abort:
			break;
			
		}
		
		
	}

}
