package designpatterns.behavioral.command;

public class CloseFileCommand implements Command {

	FileSystemReceiver fs;
	
	public CloseFileCommand(FileSystemReceiver fs) {
		this.fs=fs;
	}
	
	@Override
	public void execute() {
		fs.closeFile();
	}
}
