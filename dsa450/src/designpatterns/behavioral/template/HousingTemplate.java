package designpatterns.behavioral.template;

public abstract class HousingTemplate {
	public final void buildHouse() {
		buildFoundation();
		buildPillars();
		buildWalls();
		buildWindows();
		System.out.println("House is built");
	}

	public void buildFoundation() {
		System.out.println("Foundation built with cement and stone");
	}

	public abstract void buildWalls();

	public abstract void buildPillars();

	public void buildWindows() {
		System.out.println("Windows built with glasses");
	}
}
