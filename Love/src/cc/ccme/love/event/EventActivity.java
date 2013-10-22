package cc.ccme.love.event;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TabHost;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class EventActivity extends BaseActivity implements OnClickListener {

	private TabHost tabHost;
	private View tabSelectorOrganized,tabSelectorInvited;
	private ImageButton btnBack,btnAdd;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_event);
	}

	@Override
	protected void initView() {
		LayoutInflater mInflater = LayoutInflater.from(this); 
        tabSelectorOrganized = mInflater.inflate(R.layout.tabselector_event_organized, null);
		tabSelectorInvited = mInflater.inflate(R.layout.tabselector_event_invited, null);
		tabHost = (TabHost) findViewById(android.R.id.tabhost);	
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnAdd = (ImageButton) findViewById(R.id.btn_add);
	}

	@Override
	protected void initData() {
		tabHost.setup();
		tabHost.addTab(tabHost.newTabSpec("organized").setIndicator(tabSelectorOrganized).setContent(R.id.event_organized));
		tabHost.addTab(tabHost.newTabSpec("invited").setIndicator(tabSelectorInvited).setContent(R.id.event_invited));
		
		btnBack.setOnClickListener(this);
		btnAdd.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.btn_back:
			finish();
			break;
		case R.id.btn_add:
			startActivity(this, EventCreateActivity.class);
			break;
		
		}
		
	}





}
