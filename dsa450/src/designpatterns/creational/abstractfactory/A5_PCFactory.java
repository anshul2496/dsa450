package designpatterns.creational.abstractfactory;

public class A5_PCFactory implements A4_ComputerAbstractFactory {

	String ram;
	String hdd;
	String cpu;

	public A5_PCFactory(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public A1_Computer getComputer() {
		return new A2_PC(ram, hdd, cpu);
	}
}
