package designpatterns.structural.composite;

public class Demo {
	public static void main(String[] args) {
		Shape tri = new Triangle();
		Shape circle = new Circle();
		Drawing drawing = new Drawing();
		drawing.addShape(tri);
		drawing.addShape(circle);
		drawing.draw("Red");
		drawing.removeShape(tri);
		drawing.draw("Green");
	}
}
