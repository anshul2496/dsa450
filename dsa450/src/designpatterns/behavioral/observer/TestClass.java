package designpatterns.behavioral.observer;

public class TestClass {

	public static void main(String[] args) {
		MyObserver ob1 = new MyObserver("Observer1");
		MyObserver ob2 = new MyObserver("Observer2");
		MyObserver ob3 = new MyObserver("Observer3");

		MyTopic topic = new MyTopic();

		topic.register(ob1);
		topic.register(ob2);
		topic.register(ob3);

		ob1.setSubject(topic);
		ob2.setSubject(topic);
		ob3.setSubject(topic);

		topic.postMessage("New Message");
	}
}
