package designpatterns.behavioral.visitor;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		Item book1 = new Book(2, "abc");
		Item book2 = new Book(4, "xyz");
		Item fruit1 = new Fruit("Apple", 1, 5);

		ArrayList<Item> items = new ArrayList<>();
		items.add(book1);
		items.add(book2);
		items.add(fruit1);
		ShoppingCartVisitor visitor = new ShoppingCartVisitorImpl();
		int sum = 0;
		for (Item item : items) {
			sum = sum + item.accept(visitor);
		}
		System.out.println(sum);
	}
}
