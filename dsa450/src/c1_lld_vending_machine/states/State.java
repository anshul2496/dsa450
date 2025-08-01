package c1_lld_vending_machine.states;

import c1_lld_vending_machine.Coin;
import c1_lld_vending_machine.VendingMachine;

public abstract class State {
	VendingMachine machine;

	State(VendingMachine machine) {
		this.machine = machine;
	}

	public abstract void insertCoin(Coin coin);

	public abstract void selectItem(String code);

	public abstract void dispense();

	public abstract void refund();
}
