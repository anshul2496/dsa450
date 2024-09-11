package designpatterns.structural.bridge;

public class Circle extends Shape {

	public Circle(Color c) {
		super(c);
	}

	@Override
	public void applyColor() {
		System.out.println("Circle color");
		color.applyColor();
	}
}
