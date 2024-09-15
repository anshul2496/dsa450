package designpatterns.behavioral.command;

public class Demo {
	public static void main(String[] args) {
		FileSystemReceiver fileSystemReceiver = FileSystemReceiverUtil.getFileSystemReceiver();
		FileInvoker fileInvoker = new FileInvoker(new OpenFileCommand(fileSystemReceiver));
		fileInvoker.execute();
	}
}
