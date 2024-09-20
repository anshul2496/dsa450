package designpatterns.behavioral.template;

public class GlassHouse extends HousingTemplate {

	public void buildPillars() {
		System.out.println("Glass coated pillars built");
	}

	public void buildWalls() {
		System.out.println("Walls built");
	}
}
