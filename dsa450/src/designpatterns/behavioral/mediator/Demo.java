package designpatterns.behavioral.mediator;

public class Demo {
	public static void main(String[] args) {
		ChatMediator chatMediator = new ChatMediatorImpl();
		User a = new UserImpl(chatMediator, "Anshul");
		User b = new UserImpl(chatMediator, "Aman");
		User c = new UserImpl(chatMediator, "Rahul");
		chatMediator.addUser(a);
		chatMediator.addUser(b);
		chatMediator.addUser(c);
		chatMediator.sendMessage(a, "Ki haal?");
	}
}
