package designpatterns.factory;

public class TestClass {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("i5", "8GB", "1TB", "PC");
		System.out.println(pc);
		Computer server = ComputerFactory.getComputer("i10", "88GB", "18TB", "Server");
		System.out.println(server);
	}
}
