package c3_hotel_booking.payment;

public class CreditCardPayment implements Payment {
	@Override
	public boolean processPayment(double amount) {
		// Process credit card payment
		return true;
	}
}
