package designpatterns.structural.proxy;

public class CommandExecutorProxy implements CommandExecutor {

	private boolean isAdmin;
	private CommandExecutor commandExec;

	public CommandExecutorProxy(String user, String pwd) {
		if (user.equals("abc") && pwd.equals("xyz")) {
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
