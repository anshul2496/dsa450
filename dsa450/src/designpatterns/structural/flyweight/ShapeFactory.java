package designpatterns.structural.flyweight;

import java.util.HashMap;

public class ShapeFactory {
	private static final HashMap<ShapeType, Shape> shapes = new HashMap<>();

	public static Shape getShape(ShapeType shapeType) {
		Shape s = shapes.get(shapeType);
		if (s == null) {
			switch (shapeType) {
			case LINE:
				s = new Line();
				shapes.put(ShapeType.LINE, s);
				break;
			case OVAL_FILL:
				s = new Oval(true);
				shapes.put(ShapeType.OVAL_FILL, s);
				break;
			}
		}
		return s;
	}

	public static enum ShapeType {
		LINE, OVAL_NO_FILL, OVAL_FILL;
	}
}
