package cc.ccme.love.videoplayer;

import java.lang.ref.WeakReference;
import java.util.List;

import cc.ccme.love.util.Observable;
import cc.ccme.love.util.Observable.Observer;
import cc.ccme.love.util.Timer;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

enum VideoPlayerDoOnReady {
	nothing,
	playcover,
	playvideo
}

public class VideoPlayerView extends SurfaceView implements OnPreparedListener,
		SurfaceHolder.Callback, Observer {

	protected static final Timer switchImageTimer = new Timer(5000); 
	protected static final MediaPlayer mp = new MediaPlayer();
	protected static WeakReference<VideoPlayerView> playingInstance;
	static {
		mp.setLooping(false);
		mp.setScreenOnWhilePlaying(true);
	}

	private String src;
	private String[] covers;
	private ImageReader imageReader;
	private boolean surfaceCreated;
	private int width, height;
	private VideoPlayerDoOnReady onReady = VideoPlayerDoOnReady.nothing;

	public VideoPlayerView(Context context, AttributeSet attrs, int defStyleAttr) {
		this(context, attrs);
	}

	public VideoPlayerView(Context context) {
		this(context, null);
	}

	public VideoPlayerView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.getHolder().addCallback(this);
	}

	public void setDatasource(String src) {
		this.src = src;
	}

	public void setCovers(List<String> uri, ImageReader reader) {
		playCover();
	}

	public void playVideo() {
		if(mp.isPlaying())
			mp.stop();
		mp.reset();
		if (playingInstance != null) {
			VideoPlayerView pInst = playingInstance.get();
			if (pInst != null)
				pInst.playCover();
		}
		if (src == null) {
			return;
		}
		try {
			mp.setDataSource(src);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		switchImageTimer.removeObserver(this);
		playingInstance = new WeakReference<VideoPlayerView>(this);
		mp.prepareAsync();
		mp.setOnPreparedListener(this);
	}

	public void playCover() {
		if(!surfaceCreated) {
			onReady = VideoPlayerDoOnReady.playcover;
		} else {
			switchImageTimer.addObserver(this);
			switchImage();
		}
	}
	
	public void switchImage() {
	}

	@Override
	public void onPrepared(MediaPlayer _) {
		if(!surfaceCreated) {
			onReady = VideoPlayerDoOnReady.playvideo;
		} else {
			mp.setDisplay(getHolder());
			mp.start();
		}
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		boolean t = surfaceCreated;
		surfaceCreated = true;
		this.width = width;
		this.height = height;
		if(!t) {
			switch(onReady) {
			case nothing:
				break;
			case playcover:
				playCover();
				break;
			case playvideo:
				playVideo();
				break;
			}
		}
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		surfaceCreated = false;
	}

	@Override
	public void observableTriggered(Observable o) {
		if(o == switchImageTimer)
			switchImage();
	}
}
