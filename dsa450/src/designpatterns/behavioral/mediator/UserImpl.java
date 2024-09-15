package designpatterns.behavioral.mediator;

public class UserImpl extends User {

	public UserImpl(ChatMediator chatMediator, String name) {
		super(chatMediator, name);
	}

	@Override
	public void send(String msg) {
		System.out.println(this.name + " sending msg " + msg);
		this.chatMediator.sendMessage(this, msg);
	}

	@Override
	public void receive(String msg) {
		System.out.println(this.name + ": Received msg " + msg);
	}
}
