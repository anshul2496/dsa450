package designpatterns.behavioral.template;

public class WoodenHouse extends HousingTemplate {

	@Override
	public void buildWalls() {
		System.out.println("Wooden walls built");
	}

	@Override
	public void buildPillars() {
		System.out.println("Wooden coated pillars built");
	}
}
