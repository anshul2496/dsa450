package c1_lld_vending_machine.states;

import c1_lld_vending_machine.Coin;
import c1_lld_vending_machine.VendingMachine;

public class DispensingState extends State {
	public DispensingState(VendingMachine machine) {
		super(machine);
	}

	@Override
	public void insertCoin(Coin coin) {
		System.out.println("Currently dispensing. Please wait.");
	}

	@Override
	public void selectItem(String code) {
		System.out.println("Currently dispensing. Please wait.");
	}

	@Override
	public void dispense() {
		// already triggered by HasMoneyState
	}

	@Override
	public void refund() {
		System.out.println("Dispensing in progress. Refund not allowed.");
	}
}
