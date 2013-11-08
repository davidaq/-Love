package cc.ccme.love.videoplayer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class VideoPlayer extends FrameLayout {

	private VideoPlayerView playerView;
//	private RelativeLayout
	
	public VideoPlayer(Context context) {
		this(context, null);
	}
	
	public VideoPlayer(Context context, AttributeSet attrs, int defStyle) {
		this(context, attrs);
	}

	public VideoPlayer(Context context, AttributeSet attrs) {
		super(context, attrs);
		playerView = new VideoPlayerView(context);
		FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		playerView.setLayoutParams(lp);
		this.addView(playerView);
		
		 
	}

}
