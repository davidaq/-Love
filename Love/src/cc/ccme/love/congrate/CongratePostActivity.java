package cc.ccme.love.congrate;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;

public class CongratePostActivity extends BaseActivity implements OnClickListener{

	private ImageButton btnBack,btnOk;
	@SuppressWarnings("unused")
	private EditText edit;
	private TextView back;
	private ImageView imgBlue,imgRed,imgGreen,imgYellow;
	@Override
	protected void setContent() {
		setContentView(R.layout.activity_congrate_post);
		
	}

	@Override
	protected void initView() {
		btnBack = (ImageButton) findViewById(R.id.btn_back);
		btnOk = (ImageButton) findViewById(R.id.btn_ok);
		edit = (EditText) findViewById(R.id.edit);
		back = (TextView) findViewById(R.id.back);
		imgBlue = (ImageView) findViewById(R.id.img_blue);
		imgRed = (ImageView) findViewById(R.id.img_red);
		imgYellow = (ImageView) findViewById(R.id.img_yellow);
		imgGreen = (ImageView) findViewById(R.id.img_green);
		
	}

	@Override
	protected void initData() {
		btnBack.setOnClickListener(this);
		btnOk.setOnClickListener(this);
		imgBlue.setOnClickListener(this);
		imgRed.setOnClickListener(this);
		imgYellow.setOnClickListener(this);
		imgGreen.setOnClickListener(this);
		
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
		case R.id.img_blue:
			back.setBackgroundResource(R.drawable.ic_bg_congrate_blue_n);
			break;
		case R.id.img_green:
			back.setBackgroundResource(R.drawable.ic_bg_congrate_green_n);
			break;
		case R.id.img_red:
			back.setBackgroundResource(R.drawable.ic_bg_congrate_red_n);
			break;
		case R.id.img_yellow:
			back.setBackgroundResource(R.drawable.ic_bg_congrate_yellow_n);
			break;
		}
		
	}

}
