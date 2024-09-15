package designpatterns.behavioral.command;

public class WindowsFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Windows file open");
	}

	@Override
	public void writeFile() {
		System.out.println("Windows file write");
	}

	@Override
	public void closeFile() {
		System.out.println("Windows file close");
	}

}
