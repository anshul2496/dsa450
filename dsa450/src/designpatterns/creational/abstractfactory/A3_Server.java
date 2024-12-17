package designpatterns.creational.abstractfactory;

public class A3_Server implements A1_Computer {

	String ram;
	String hdd;
	String cpu;

	public A3_Server(String ram, String hdd, String cpu) {
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getRam() {
		return this.ram;
	}

	@Override
	public String getHDD() {
		return this.hdd;
	}

	@Override
	public String getCPU() {
		return this.cpu;
	}

	@Override
	public String toString() {
		return "A3_Server [ram=" + ram + ", hdd=" + hdd + ", cpu=" + cpu + "]";
	}
	
}
