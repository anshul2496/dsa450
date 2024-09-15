package designpatterns.behavioral.command;

public class WriteFileCommand implements Command {

	FileSystemReceiver fs;

	public WriteFileCommand(FileSystemReceiver fs) {
		this.fs = fs;
	}

	@Override
	public void execute() {
		this.fs.writeFile();
	}
}
