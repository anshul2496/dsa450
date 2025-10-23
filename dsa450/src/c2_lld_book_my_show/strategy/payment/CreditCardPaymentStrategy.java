package c2_lld_book_my_show.strategy.payment;

import java.util.UUID;

import c2_lld_book_my_show.entities.Payment;
import c2_lld_book_my_show.enums.PaymentStatus;

public class CreditCardPaymentStrategy implements PaymentStrategy {
	private final String cardNumber;
	private final String cvv;

	public CreditCardPaymentStrategy(String cardNumber, String cvv) {
		this.cardNumber = cardNumber;
		this.cvv = cvv;
	}

	@Override
	public Payment pay(double amount) {
		System.out.println("Processing credit card payment of " + amount);
		// Simulate payment gateway interaction
		boolean paymentSuccess = Math.random() > 0.05; // 95% success rate
		return new Payment(amount, paymentSuccess ? PaymentStatus.SUCCESS : PaymentStatus.FAILURE,
				"TXN_" + UUID.randomUUID());
	}
}
