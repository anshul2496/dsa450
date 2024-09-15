package designpatterns.behavioral.chainofresp;

public class DispenseChain50 implements DispenseChain {

	private DispenseChain dispenseChain;

	@Override
	public void setNextChain(DispenseChain nextChain) {
		this.dispenseChain = nextChain;
	}

	@Override
	public void dispense(Currency curr) {
		int amnt = curr.getAmount();
		if (amnt >= 50) {
			int fifties = amnt / 50;
			int rem = amnt % 50;
			System.out.println("Dispensing " + fifties + " notes of 50");
			if (rem == 0)
				this.dispenseChain.dispense(curr);
			else
				this.dispenseChain.dispense(new Currency(rem));
		}
	}

}
