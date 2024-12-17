package designpatterns.creational.abstractfactory;

public class A6_ServerFactory implements A4_ComputerAbstractFactory {

	String ram;
	String hdd;
	String cpu;

	public A6_ServerFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public A1_Computer getComputer() {
		return new A3_Server(ram, hdd, cpu);
	}
}
