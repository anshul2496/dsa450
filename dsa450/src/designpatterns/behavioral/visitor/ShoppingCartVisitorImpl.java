package designpatterns.behavioral.visitor;

public class ShoppingCartVisitorImpl implements ShoppingCartVisitor {

	public int visit(Book book) {
		return book.getPrice();
	}

	public int visit(Fruit fruit) {
		return fruit.getPrice() * fruit.getWeight();
	}
}
