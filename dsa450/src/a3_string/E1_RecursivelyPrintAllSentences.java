package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/1
 */
public class E1_RecursivelyPrintAllSentences {
	public static void main(String[] args) {
		String[][] arr = { { "you", "we", "" }, { "have", "are", "" }, { "sleep", "eat", "drink" } };
		print(arr);
	}

	private static void print(String[][] arr) {
		int rows = arr.length;
		int cols = arr[0].length;
		String[] output = new String[rows];
		for (int i = 0; i < cols; i++) {
			if (!arr[0][i].equals("")) {
				printUtil(arr, 0, i, output, rows, cols);
			}
		}
	}

	private static void printUtil(String[][] arr, int m, int n, String[] output, int rows, int cols) {
		output[m] = arr[m][n];
		if (m == rows - 1) {
			for (int i = 0; i < rows; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < cols; i++) {
			if (!arr[m + 1][i].equals("") && m < cols) {
				printUtil(arr, m + 1, i, output, rows, cols);
			}
		}

	}
}
