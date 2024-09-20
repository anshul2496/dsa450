package designpatterns.behavioral.template;

public class Demo {
	public static void main(String[] args) {
		HousingTemplate housingTemplate = new WoodenHouse();
		housingTemplate.buildHouse();
	}
}
