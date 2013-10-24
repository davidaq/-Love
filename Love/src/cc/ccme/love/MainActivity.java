package cc.ccme.love;

import cc.ccme.love.fragment.BroadcastFragment;
import cc.ccme.love.fragment.ContactFragment;
import cc.ccme.love.fragment.LeftMenuFragment;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends SlidingFragmentActivity {

	public static SlidingMenu menuLeft,menuRight;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_broadcast);
        
        setBehindContentView(R.layout.frame_contact);
       
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.contact, new ContactFragment());
        fragmentTransaction.replace(R.id.broadcast, new BroadcastFragment());
        fragmentTransaction.replace(R.id.left_menu, new LeftMenuFragment());
        fragmentTransaction.commit();
        
        menuRight = getSlidingMenu();
        menuRight.setMode(SlidingMenu.RIGHT);
        menuRight.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menuRight.setShadowWidthRes(R.dimen.shadow_width);
        menuRight.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menuRight.setFadeDegree(0.35f);
                
        menuLeft = new SlidingMenu(this);
		menuLeft.setMode(SlidingMenu.LEFT);
        menuLeft.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menuLeft.setShadowWidthRes(R.dimen.shadow_width);
        menuLeft.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menuLeft.setFadeDegree(0.35f);
        menuLeft.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menuLeft.setMenu(R.layout.frame_left_menu);
        
        menuLeft.setOnOpenedListener(new OnOpenedListener()
        {
			@Override
			public void onOpened() {
				menuRight.setSlidingEnabled(false);
			}
        	
        });
        menuLeft.setOnClosedListener(new OnClosedListener()
        {

			@Override
			public void onClosed() {
				menuRight.setSlidingEnabled(true);
			}
        	
        });
        
        menuRight.setOnOpenedListener(new OnOpenedListener()
        {
			@Override
			public void onOpened() {
				menuLeft.setSlidingEnabled(false);
			}
        	
        });
        menuRight.setOnClosedListener(new OnClosedListener()
        {

			@Override
			public void onClosed() {
				menuLeft.setSlidingEnabled(true);
			}
        	
        });

    }
}

