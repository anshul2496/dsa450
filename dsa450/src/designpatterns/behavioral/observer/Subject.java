package designpatterns.behavioral.observer;

public interface Subject {
	public void register(Observer ob);

	public void unregister(Observer ob);

	public void notifyAllObservers();

	public String getUpdate();
}
