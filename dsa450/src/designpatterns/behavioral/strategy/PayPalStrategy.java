package designpatterns.behavioral.strategy;

public class PayPalStrategy implements PaymentStrategy {
	String email;
	String pwd;

	public PayPalStrategy(String email, String pwd) {
		this.email = email;
		this.pwd = pwd;
	}

	public void pay(int amount) {
		System.out.println(amount + " Paid via PayPal");
	}
}
