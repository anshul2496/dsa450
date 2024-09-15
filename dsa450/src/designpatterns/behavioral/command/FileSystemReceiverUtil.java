package designpatterns.behavioral.command;

public class FileSystemReceiverUtil {

	private FileSystemReceiverUtil() {
	}

	public static FileSystemReceiver getFileSystemReceiver() {
		String osName = System.getProperty("os.name");
		if (osName.contains("Windows"))
			return new WindowsFileSystemReceiver();
		else
			return new MacFileSystemReceiver();
	}
}
