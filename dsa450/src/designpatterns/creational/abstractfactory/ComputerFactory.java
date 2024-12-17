package designpatterns.creational.abstractfactory;

public class ComputerFactory {

	public static A1_Computer getPC(String ram, String hdd, String cpu) {
		return new A5_PCFactory(ram, hdd, cpu).getComputer();
	}

	public static A1_Computer getServer(String ram, String hdd, String cpu) {
		return new A6_ServerFactory(ram, hdd, cpu).getComputer();
	}
}
