package designpatterns.behavioral.observer;

public interface Observer {
	public void setSubject(Subject subject);

	public void update();
}
