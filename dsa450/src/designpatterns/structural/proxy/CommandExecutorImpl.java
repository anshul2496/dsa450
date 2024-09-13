package designpatterns.structural.proxy;

public class CommandExecutorImpl implements CommandExecutor {

	@Override
	public void runCommand(String cmd) {
		System.out.println("Executing cmd " + cmd);
	}
}
