package designpatterns.behavioral.command;

public class MacFileSystemReceiver implements FileSystemReceiver {

	@Override
	public void openFile() {
		System.out.println("Mac open file");
	}

	@Override
	public void writeFile() {
		System.out.println("Mac write file");
		
	}

	@Override
	public void closeFile() {
		System.out.println("Mac close file");
	}
}
