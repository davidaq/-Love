package cc.ccme.love.event;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class EventCreateActivity extends BaseActivity implements OnClickListener{

	private ImageButton btnBack,btnOk;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_event_create);
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnOk = (ImageButton) findViewById(R.id.btn_ok);
	}

	@Override
	protected void initData() {
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
