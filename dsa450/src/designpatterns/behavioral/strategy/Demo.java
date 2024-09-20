package designpatterns.behavioral.strategy;

public class Demo {
	public static void main(String[] args) {
		ShoppingCart shoppingCart = new ShoppingCart();
		Item a = new Item("abc", 1);
		Item b = new Item("pqr", 2);
		Item c = new Item("xyz", 3);
		shoppingCart.addItem(a);
		shoppingCart.addItem(b);
		shoppingCart.addItem(c);
		shoppingCart.pay(new PayPalStrategy("myemail", "mypwd"));
	}
}
