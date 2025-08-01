package c1_lld_vending_machine.states;

import c1_lld_vending_machine.Coin;
import c1_lld_vending_machine.VendingMachine;

public class ItemSelectedState extends State {
	public ItemSelectedState(VendingMachine machine) {
		super(machine);
	}

	@Override
	public void insertCoin(Coin coin) {
		machine.addBalance(coin.getValue());
		System.out.println("Coin Inserted: " + coin.getValue());
		int price = machine.getSelectedItem().getPrice();
		if (machine.getBalance() >= price) {
			System.out.println("Sufficient money received.");
			machine.setState(new HasMoneyState(machine));
		}
	}

	@Override
	public void selectItem(String code) {
		System.out.println("Item already selected.");
	}

	@Override
	public void dispense() {
		System.out.println("Please insert sufficient money.");
	}

	@Override
	public void refund() {
		machine.reset();
		machine.setState(new IdleState(machine));
	}
}
