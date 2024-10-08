package designpatterns.structural.bridge;

public class Triangle extends Shape {

	public Triangle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.println("Triangle Color");
		color.applyColor();
	}
}
