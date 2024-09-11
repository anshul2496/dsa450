package designpatterns.structural.composite;

public class Triangle implements Shape {
	public void draw(String color) {
		System.out.println("Triangle drawn with color " + color);
	}
}
