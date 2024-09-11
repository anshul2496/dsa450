package designpatterns.structural.composite;

public class Circle implements Shape {

	@Override
	public void draw(String color) {
		System.out.println("Circle drawn with color " + color);
	}

}
