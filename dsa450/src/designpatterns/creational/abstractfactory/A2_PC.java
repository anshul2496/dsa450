package designpatterns.creational.abstractfactory;

public class A2_PC implements A1_Computer {

	String ram;
	String hdd;
	String cpu;

	public A2_PC(String ram, String hdd, String cpu) {
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
		return "A2_PC [ram=PC" + ram + ", hdd=PC" + hdd + ", cpu=PC" + cpu + "]";
	}
}
