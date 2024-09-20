package designpatterns.behavioral.visitor;

public interface ShoppingCartVisitor {
	public int visit(Book book);

	public int visit(Fruit fruit);
}
