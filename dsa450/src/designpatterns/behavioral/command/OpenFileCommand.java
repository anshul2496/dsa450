package designpatterns.behavioral.command;

public class OpenFileCommand implements Command {

	FileSystemReceiver fs;
	
	public OpenFileCommand(FileSystemReceiver fs) {
		this.fs=fs;
	}
	
	@Override
	public void execute() {
		fs.openFile();
	}
}
