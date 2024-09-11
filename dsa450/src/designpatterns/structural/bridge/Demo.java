package designpatterns.structural.bridge;

public class Demo {
	public static void main(String[] args) {
		Shape s1 = new Circle(new RedColor());
		Shape s2 = new Triangle(new GreenColor());
		s1.applyColor();
		s2.applyColor();
	}
}
