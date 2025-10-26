package c6_online_shopping_service.strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy {
	private final String cardNumber;

	public CreditCardPaymentStrategy(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public boolean pay(double amount) {
		System.out.println("Processing credit card payment");
		// Simulate payment gateway logic
		return true;
	}
}
