package designpatterns.behavioral.mediator;

public abstract class User {
	protected ChatMediator chatMediator;
	protected String name;

	protected User(ChatMediator chatMediator, String name) {
		this.chatMediator = chatMediator;
		this.name = name;
	}

	public abstract void send(String msg);

	public abstract void receive(String msg);
}
