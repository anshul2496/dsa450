package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

	private List<Observer> observers;
	private String message;
	private boolean changed;
	private final Object MUTEX = new Object();

	public MyTopic() {
		observers = new ArrayList<>();
	}

	@Override
	public void register(Observer ob) {
		observers.add(ob);
	}

	@Override
	public void unregister(Observer ob) {
		observers.remove(ob);
	}

	@Override
	public void notifyAllObservers() {
		synchronized (MUTEX) {
			if (!changed)
				return;
			changed = false;
			for (Observer ob : observers) {
				ob.update();
			}			
		}
	}

	@Override
	public String getUpdate() {
		return this.message;
	}

	public void postMessage(String message) {
		this.message = message;
		this.changed = true;
		notifyAllObservers();
	}
}
