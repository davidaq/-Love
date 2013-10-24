package cc.ccme.love.contact;

import java.util.Arrays;
import java.util.List;

import cc.ccme.love.BaseFragment;
import cc.ccme.love.R;
import cc.ccme.love.util.PinyinComparator;
import cc.ccme.love.util.PinyinUtils;
import cc.ccme.love.widget.MySideBar;
import cc.ccme.love.widget.MySideBar.OnTouchingLetterChangedListener;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("HandlerLeak")
public class ContactSingleFragment extends BaseFragment implements
OnTouchingLetterChangedListener {

private ListView lvShow;
private List<UserInfo> userInfos;
private TextView overlay;
private MySideBar myView;
private MyUserInfoAdapter adapter;

private OverlayThread overlayThread = new OverlayThread();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_contact_single, null);
        lvShow = (ListView) view.findViewById(R.id.lvShow);
		myView = (MySideBar) view.findViewById(R.id.myView);

		overlay = (TextView) view.findViewById(R.id.tvLetter);

		lvShow.setTextFilterEnabled(true);
		overlay.setVisibility(View.INVISIBLE);

		getUserInfos();

		adapter = new MyUserInfoAdapter(getActivity(), userInfos);

		lvShow.setAdapter(adapter);

		myView.setOnTouchingLetterChangedListener(this);
        return view;
    }

    private void getUserInfos() {

		UserInfo[] userinfoArray = new UserInfo[] {
				new UserInfo("唐僧", "18765432345", PinyinUtils.getAlpha("唐僧")),
                new UserInfo("猪师弟", "18765432345", PinyinUtils.getAlpha("猪师弟")),
                new UserInfo("阿呆", "18765432345", PinyinUtils.getAlpha("阿呆")),
                new UserInfo("8899", "18765432345", PinyinUtils.getAlpha("8899")),
                new UserInfo("孙悟空", "18765432345", PinyinUtils.getAlpha("孙悟空")),
                new UserInfo("阿三", "18765432345", PinyinUtils.getAlpha("阿三")),
                new UserInfo("张三", "18765432345", PinyinUtils.getAlpha("张三")),
                new UserInfo("张二B", "18876569008", PinyinUtils.getAlpha("张二B")),
                new UserInfo("阿三", "18765432345", PinyinUtils.getAlpha("阿三")),
                new UserInfo("张三", "18765432345", PinyinUtils.getAlpha("张三")),
                new UserInfo("张二B", "18876569008", PinyinUtils.getAlpha("张二B")),
                new UserInfo("阿三", "18765432345", PinyinUtils.getAlpha("阿三")),
                new UserInfo("张三", "18765432345", PinyinUtils.getAlpha("张三")),
                new UserInfo("张二B", "18876569008", PinyinUtils.getAlpha("张二B")),
                new UserInfo("阿三", "18765432345", PinyinUtils.getAlpha("阿三")),
                new UserInfo("张三", "18765432345", PinyinUtils.getAlpha("张三")),
                new UserInfo("张二B", "18876569008", PinyinUtils.getAlpha("张二B")),
                new UserInfo("李四", "18909876545", PinyinUtils.getAlpha("李四")),
                new UserInfo("王小二", "18909876545", PinyinUtils.getAlpha("王小二")),
                new UserInfo("张三丰", "18909876545", PinyinUtils.getAlpha("张三丰")),
                new UserInfo("郭靖", "18909876545", PinyinUtils.getAlpha("郭靖")),
                new UserInfo("张无忌", "18909876545", PinyinUtils.getAlpha("张无忌")),
                new UserInfo("黄小贤", "18909876545", PinyinUtils.getAlpha("黄小贤")) };

		Arrays.sort(userinfoArray, new PinyinComparator());

		userInfos = Arrays.asList(userinfoArray);

	}

	private Handler handler = new Handler() {
	};

	private class OverlayThread implements Runnable {

		public void run() {
			overlay.setVisibility(View.GONE);
		}

	}

	@Override
	public void onTouchingLetterChanged(String s) {

		overlay.setText(s);
		overlay.setVisibility(View.VISIBLE);
		handler.removeCallbacks(overlayThread);
		handler.postDelayed(overlayThread, 1000);
		if (alphaIndexer(s) > 0) {
			int position = alphaIndexer(s);
			lvShow.setSelection(position);

		}
	}

	public int alphaIndexer(String s) {
		int position = 0;
		for (int i = 0; i < userInfos.size(); i++) {

			if (userInfos.get(i).getPy().startsWith(s)) {
				position = i;
				break;
			}
		}
		return position;
	}
    
}
