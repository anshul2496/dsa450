package designpatterns.structural.flyweight;

public class Line implements Shape {

	public Line() {
		System.out.println("Line Object");
	}
	
	@Override
	public void draw(int x, int y) {
		// Draw a line
	}
}
