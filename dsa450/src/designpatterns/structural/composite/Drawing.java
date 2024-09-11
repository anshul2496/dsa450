package designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Drawing implements Shape {

	List<Shape> shapes = new ArrayList<>();

	@Override
	public void draw(String color) {
		for (Shape s : shapes) {
			s.draw(color);
		}
	}

	public void addShape(Shape s) {
		shapes.add(s);
	}

	public void removeShape(Shape s) {
		shapes.remove(s);
	}

	public void clear() {
		shapes.clear();
		System.out.println("All shapes cleared");
	}
}
