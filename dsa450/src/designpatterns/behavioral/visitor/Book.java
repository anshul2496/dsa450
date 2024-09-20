package designpatterns.behavioral.visitor;

public class Book implements Item {

	private Integer price;
	private String code;

	public Book(Integer price, String code) {
		this.price = price;
		this.code = code;
	}

	public Integer getPrice() {
		return this.price;
	}

	public String getCode() {
		return this.code;
	}

	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}