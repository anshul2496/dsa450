package designpatterns.observer;

public class MyObserver implements Observer {

	private Subject subject;
	private String name;
	
	public MyObserver(String name) {
		this.name = name;
	}
	
	@Override
	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	@Override
	public void update() {
		String message = this.subject.getUpdate();
		System.out.println(this.name + " = " + message);
	}
}
