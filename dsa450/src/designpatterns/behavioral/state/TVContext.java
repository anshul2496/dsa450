package designpatterns.behavioral.state;

public class TVContext implements State {

	State state;

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}

	@Override
	public void doAction() {
		this.state.doAction();
	}

}
