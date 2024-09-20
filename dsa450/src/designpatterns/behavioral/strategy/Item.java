package designpatterns.behavioral.strategy;

public class Item {

	String code;
	Integer price;

	public Item(String code, Integer price) {
		this.code = code;
		this.price = price;
	}

	public String getCode() {
		return this.code;
	}

	public Integer getPrice() {
		return this.price;
	}
}
