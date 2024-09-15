package designpatterns.behavioral.chainofresp;

public class Demo {

	DispenseChain c1;

	public Demo() {
		c1 = new DispenseChain50();
		DispenseChain c2 = new DispenseChain10();
		c1.setNextChain(c2);
	}

	public static void main(String[] args) {
		Demo demo = new Demo();
		int amnt = 110;
		demo.c1.dispense(new Currency(amnt));
	}
}
