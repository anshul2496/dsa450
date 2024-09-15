package designpatterns.behavioral.mediator;

public interface ChatMediator {
	public void sendMessage(User user, String msg);

	public void addUser(User user);
}
