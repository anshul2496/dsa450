package designpatterns.behavioral.chainofresp;

public class DispenseChain10 implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispense(Currency curr) {
		int amnt = curr.getAmount();
		if (amnt >= 10) {
			int num = amnt / 10;
			int rem = amnt % 10;
			System.out.println("Dispensing " + num + " notes of 10");
			if (rem != 0)
				this.chain.dispense(new Currency(rem));
		}
	}
}
