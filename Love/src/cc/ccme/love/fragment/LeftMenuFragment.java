package cc.ccme.love.fragment;

import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.album.GalleryActivity;
import cc.ccme.love.congrate.CongrateActivity;
import cc.ccme.love.event.EventActivity;
import cc.ccme.love.person.PersonActivity;
import cc.ccme.love.video.VideoActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class LeftMenuFragment extends BaseFragment implements OnClickListener {

	private ImageView avatar;
	@SuppressWarnings("unused")
	private TextView userName,signature,age,attentionCount,fansCount;
	private ImageButton messageEvent,messageContent,messagePrivate;
	private TextView menuBroadcast,menuPerson,menuEvent,menuAlbum,menuVideo,menuCongrate,menuSettings;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left_menu, null);
        initView(view);
        return view;
    }
    
    private void initView(View view)
    {
    	avatar = (ImageView) view.findViewById(R.id.avatar);
    	userName = (TextView) view.findViewById(R.id.username);
    	signature = (TextView) view.findViewById(R.id.signature);
    	age = (TextView) view.findViewById(R.id.age);
    	attentionCount = (TextView) view.findViewById(R.id.attention_count);
    	fansCount = (TextView) view.findViewById(R.id.fans_count);
    	
    	messageEvent = (ImageButton) view.findViewById(R.id.event_message);
    	messageContent = (ImageButton) view.findViewById(R.id.content_message);
    	messagePrivate = (ImageButton) view.findViewById(R.id.private_message);

    	menuBroadcast = (TextView) view.findViewById(R.id.broadcast);
    	menuPerson = (TextView) view.findViewById(R.id.person);
    	menuEvent = (TextView) view.findViewById(R.id.event);
    	menuAlbum = (TextView) view.findViewById(R.id.album);
    	menuVideo = (TextView) view.findViewById(R.id.video);
    	menuCongrate = (TextView) view.findViewById(R.id.congrate);
    	menuSettings = (TextView) view.findViewById(R.id.settings);
    	
    	avatar.setOnClickListener(this);
    	
    	messageEvent.setOnClickListener(this);
    	messageContent.setOnClickListener(this);
    	messagePrivate.setOnClickListener(this);
    	
    	menuBroadcast.setOnClickListener(this);
    	menuPerson.setOnClickListener(this);
    	menuEvent.setOnClickListener(this);
    	menuAlbum.setOnClickListener(this);
    	menuVideo.setOnClickListener(this);
    	menuCongrate.setOnClickListener(this);
    	menuSettings.setOnClickListener(this);
    }

	@Override
	public void onClick(View view) {
		switch(view.getId())
		{
		case R.id.avatar:
			startActivity(PersonActivity.class);
			break;
		case R.id.event_message:
			break;
		case R.id.content_message:
			break;
		case R.id.private_message:
			break;
		
		case R.id.broadcast:
			leftToggle();
			break;
		case R.id.person:
			startActivity(PersonActivity.class);
			break;
		case R.id.event:
			startActivity(EventActivity.class);
			break;
		case R.id.album:
			startActivity(GalleryActivity.class);
			break;
		case R.id.video:
			startActivity(VideoActivity.class);
			break;
		case R.id.congrate:
			startActivity(CongrateActivity.class);
			break;
		case R.id.settings:
			break;
		}
		
	}
    
}
