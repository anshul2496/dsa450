package c6_online_shopping_service.state;

import c6_online_shopping_service.enums.OrderStatus;
import c6_online_shopping_service.models.Order;

public class ShippedState implements OrderState {
	@Override
	public void ship(Order order) {
		System.out.println("Order is already shipped.");
	}

	@Override
	public void deliver(Order order) {
		System.out.println("Delivering order " + order.getId());
		order.setStatus(OrderStatus.DELIVERED);
		order.setState(new DeliveredState());
	}

	@Override
	public void cancel(Order order) {
		System.out.println("Cannot cancel a shipped order.");
	}
}
