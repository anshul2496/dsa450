package designpatterns.structural.flyweight;

public class Oval implements Shape {

	protected boolean fill;

	public Oval(boolean fill) {
		this.fill = fill;
		System.out.println("An Oval Object");
	}

	@Override
	public void draw(int x, int y) {
		// Draw an oval
	}
}
