package designpatterns.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor commandExec;

	public CommandExecutorProxy(String user) {
		if (user.equals("abc")) {
			isAdmin = true;
		}
		commandExec = new CommandExecutorImpl();
	}

	@Override
	public void runCommand(String cmd) {
		if (isAdmin)
			commandExec.runCommand(cmd);
		else {
			if (cmd.contains("rm")) {
				System.out.println("you are not an admin");
				return;
			}
			commandExec.runCommand(cmd);
		}
	}
}
