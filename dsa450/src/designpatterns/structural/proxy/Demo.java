package designpatterns.structural.proxy;

public class Demo {
	public static void main(String[] args) {
		CommandExecutor proxy = new CommandExecutorProxy("abc");
		proxy.runCommand("rm");
	}
}
