package designpatterns.behavioral.state;

public class Demo {
	public static void main(String[] args) {
		TVContext tvContext = new TVContext();
		TVStartState tvStartState = new TVStartState();
		TVOffState tvOffState = new TVOffState();

		tvContext.setState(tvStartState);
		tvContext.doAction();

		tvContext.setState(tvOffState);
		tvContext.doAction();
	}
}
