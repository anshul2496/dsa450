package interviews;

/*
 * https://leetcode.com/problems/excel-sheet-column-number/
 */
public class A21_Base26ToDecimal {
	public static void main(String[] args) {
		String columnTitle = "ZY";
		int columnNumber = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			int currentColumn = columnTitle.charAt(i) - 'A' + 1;
			columnNumber = (columnNumber * 26) + currentColumn;
		}
		System.out.println(columnNumber);
	}
}
