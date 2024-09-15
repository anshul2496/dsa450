package designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator {

	List<User> users;

	public ChatMediatorImpl() {
		users = new ArrayList<>();
	}

	@Override
	public void sendMessage(User user, String msg) {
		for (User u : users) {
			if (!u.name.equals(user.name)) {
				u.receive(msg);
			}
		}
	}

	@Override
	public void addUser(User user) {
		this.users.add(user);
	}

}
