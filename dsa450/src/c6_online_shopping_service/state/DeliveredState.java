package c6_online_shopping_service.state;

import c6_online_shopping_service.models.Order;

public class DeliveredState implements OrderState {
	@Override
	public void ship(Order order) {
		System.out.println("Order already delivered.");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Order already delivered.");
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Cannot cancel a delivered order.");
	}
}
