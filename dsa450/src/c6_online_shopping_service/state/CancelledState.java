package c6_online_shopping_service.state;

import c6_online_shopping_service.models.Order;

public class CancelledState implements OrderState {
	@Override
	public void ship(Order order) {
		System.out.println("Cannot ship a cancelled order.");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Cannot deliver a cancelled order.");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Order is already cancelled.");
	}
}
