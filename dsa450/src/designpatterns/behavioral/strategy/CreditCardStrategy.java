package designpatterns.behavioral.strategy;

public class CreditCardStrategy implements PaymentStrategy {

	String cardNo;
	String name;
	String cvv;

	public CreditCardStrategy(String cardNo, String name, String cvv) {
		this.cardNo = cardNo;
		this.name = name;
		this.cvv = cvv;
	}

	public void pay(int amount) {
		System.out.println(amount + " Paid via CreditCard");
	}
}
