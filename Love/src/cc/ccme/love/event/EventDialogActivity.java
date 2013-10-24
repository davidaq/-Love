package cc.ccme.love.event;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import cc.ccme.love.BaseActivity;
import cc.ccme.love.R;


public class EventDialogActivity extends BaseActivity implements OnClickListener {


	private ImageButton btnMessage,btnInvitation,btnWish,btnCheck,btnShare;
	private LinearLayout linear01,linear02;
	@Override
	protected void setContent() {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setBackgroundDrawable(new ColorDrawable(0));
		setContentView(R.layout.activity_event_dialog);
		
	}

	@Override
	protected void initView() {
		btnMessage = (ImageButton) findViewById(R.id.message);
		btnInvitation = (ImageButton) findViewById(R.id.invitation);
		btnWish = (ImageButton) findViewById(R.id.wish);
		btnCheck = (ImageButton) findViewById(R.id.check);
		btnShare = (ImageButton) findViewById(R.id.share);

		linear01 = (LinearLayout) findViewById(R.id.linear01);
		linear02 = (LinearLayout) findViewById(R.id.linear02);
		
	}

	@Override
	protected void initData() {
		btnMessage.setOnClickListener(this);
		btnInvitation.setOnClickListener(this);
		btnWish.setOnClickListener(this);
		btnCheck.setOnClickListener(this);
		btnShare.setOnClickListener(this);
		
		final Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_dialog_button_in);
		final LayoutAnimationController lac = new LayoutAnimationController(anim);
        lac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        lac.setDelay(0.1f);
        linear01.setLayoutAnimation(lac);
        linear02.setLayoutAnimation(lac);
        linear02.setVisibility(View.INVISIBLE);
        linear01.startLayoutAnimation();
        linear01.setLayoutAnimationListener(new AnimationListener()
        {
			@Override
			public void onAnimationEnd(Animation animation) {
				linear02.setVisibility(View.VISIBLE);				
				linear02.startLayoutAnimation();
			}

			@Override
			public void onAnimationRepeat(Animation animation) {				
			}

			@Override
			public void onAnimationStart(Animation animation) {	
				
			}
        	
        });
	}

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.message:
			break;
		case R.id.invitation:
			break;
		case R.id.wish:
			break;
		case R.id.check:
			break;
		case R.id.share:
			break;
			
			
		
		}
		
	}



}
