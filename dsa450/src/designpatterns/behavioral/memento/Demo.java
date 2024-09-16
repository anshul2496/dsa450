package designpatterns.behavioral.memento;

public class Demo {
	public static void main(String[] args) {
		FileWriterCaretaker fileWriterCaretaker = new FileWriterCaretaker();
		FileWriterUtil fileWriterUtil = new FileWriterUtil("data.txt");
		fileWriterUtil.write("1st set of data");
		System.out.println(fileWriterUtil.toString());
		fileWriterCaretaker.save(fileWriterUtil);
		fileWriterUtil.write("2nd set of data");
		System.out.println(fileWriterUtil.toString());
		fileWriterCaretaker.undo(fileWriterUtil);
		System.out.println(fileWriterUtil.toString());
	}
}
