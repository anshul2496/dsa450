package c6_online_shopping_service.services;

import c6_online_shopping_service.strategy.PaymentStrategy;

public class PaymentService {
	public boolean processPayment(PaymentStrategy strategy, double amount) {
		return strategy.pay(amount);
	}
}
