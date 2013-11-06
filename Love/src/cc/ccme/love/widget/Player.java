package cc.ccme.love.widget;

import cc.ccme.love.R;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Player extends RelativeLayout {
	
	private LoveVideoView videoView;
	private ToggleButton btnPlay,btnZoom;
	private String url;
	private boolean hasPlayed = false;
	public Player(Context context) {
		this(context,null);

	}

	public Player(Context context, AttributeSet attrs) {
		this(context, attrs,0);

	}

	public Player(final Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		View view=View.inflate(context, R.layout.widget_player, null);
		this.addView(view);
		btnPlay = (ToggleButton) view.findViewById(R.id.btn_play);
		btnZoom = (ToggleButton) view.findViewById(R.id.btn_zoom);
		videoView = (LoveVideoView) view.findViewById(R.id.video_view);
		
        btnPlay.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isPaused) {
				if(!isPaused)
				{
					videoView.pause();							
				}
				else
				{				
					if(!hasPlayed)
					{
						Uri uri = Uri.parse(url);  		 
				        videoView.setVideoURI(uri); 
						MediaController mc = new MediaController(context);
						mc.setVisibility(View.GONE);
				        videoView.setMediaController(mc); 
					}
					videoView.start();
					videoView.requestFocus(); 
					hasPlayed = true;
				}
				
			}
        	
        });
        btnZoom.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {

			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean isWindow) {
				if(!isWindow)
				{
					
				}
				
			}
        	
        });
	}
	
	public void setResource(String url)
	{
		 this.url = url;
         
	}
	

	
}
