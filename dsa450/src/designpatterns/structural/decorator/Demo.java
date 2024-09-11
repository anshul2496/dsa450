package designpatterns.structural.decorator;

public class Demo {
	public static void main(String[] args) {
		Car sc = new SportsCar(new BasicCar());
		sc.assemble();
		Car slc = new SportsCar(new LuxuryCar(new BasicCar()));
		slc.assemble();
	}
}
