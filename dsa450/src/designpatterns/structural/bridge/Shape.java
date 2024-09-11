package designpatterns.structural.bridge;

public abstract class Shape {
	//Composition - implementor
	public Color color;

	//Composition - implementor
	public Shape(Color c) {
		this.color = c;
	}
	
	public abstract void applyColor();
}
