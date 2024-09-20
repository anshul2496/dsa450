package designpatterns.behavioral.visitor;

public class Fruit implements Item {
	private String name;
	private Integer weight;
	private Integer price;

	public Fruit(String name, Integer weight, Integer price) {
		this.name = name;
		this.weight = weight;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public Integer getWeight() {
		return weight;
	}

	public Integer getPrice() {
		return price;
	}

	public int accept(ShoppingCartVisitor visitor) {
		return visitor.visit(this);
	}
}
