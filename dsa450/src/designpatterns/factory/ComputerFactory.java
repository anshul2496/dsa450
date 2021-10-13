package designpatterns.factory;

public class ComputerFactory {

	public static Computer getComputer(String cpu, String ram, String hdd, String type) {
		if (type.equals("PC")) {
			return new PC(cpu, ram, hdd);
		} else {
			return new Server(cpu, ram, hdd);
		}
	}
}
