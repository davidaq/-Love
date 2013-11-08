package cc.ccme.love.util;

import java.util.WeakHashMap;

public class Observable {
	public interface Observer {
		public void observableTriggered(Observable o);
	}
	WeakHashMap<Observer, Observable> observers = new WeakHashMap<Observer, Observable>();
	public void addObserver(Observer o) {
		observers.put(o, this);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	protected void signal() {
		for(Observer o : observers.keySet()) {
			if(o != null) {
				o.observableTriggered(this);
			}
		}
	}
}
