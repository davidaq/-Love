package cc.ccme.love.util;

import android.os.Handler;
import android.os.Message;

public class Timer extends Observable {
	
	protected int interval;
	
	public Timer(int intervalMillis) {
		interval = intervalMillis;
		Message m = new Message();
		m.obj = this;
		handler.sendMessage(m);
	}
	
	private static Handler handler = new Handler() {
		@Override
		public void handleMessage(Message m) {
			Timer t = (Timer) m.obj;
			t.signal();
			this.sendMessageDelayed(m, t.interval);
		}
	};
}
