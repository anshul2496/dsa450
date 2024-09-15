package designpatterns.behavioral.chainofresp;

public interface DispenseChain {
	public void setNextChain(DispenseChain nextChain);

	public void dispense(Currency curr);
}
