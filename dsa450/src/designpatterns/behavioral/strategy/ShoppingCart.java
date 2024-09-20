package designpatterns.behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	List<Item> items;

	public ShoppingCart() {
		this.items = new ArrayList<>();
	}

	public void addItem(Item item) {
		this.items.add(item);
	}

	public void pay(PaymentStrategy paymentStrategy) {
		int sum = 0;
		for (Item item : items) {
			sum += item.price;
		}
		paymentStrategy.pay(sum);
	}
}
