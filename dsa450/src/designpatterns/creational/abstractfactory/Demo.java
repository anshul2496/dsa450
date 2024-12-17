package designpatterns.creational.abstractfactory;

public class Demo {
	public static void main(String[] args) {
		A1_Computer pc = ComputerFactory.getPC("ram", "hdd", "cpu");
		System.out.println(pc);
	}
}