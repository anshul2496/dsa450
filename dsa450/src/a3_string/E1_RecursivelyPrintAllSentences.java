package a3_string;

import java.util.ArrayList;

/*
 * https://practice.geeksforgeeks.org/problems/recursively-print-all-sentences-that-can-be-formed-from-list-of-word-lists/1
 */
public class E1_RecursivelyPrintAllSentences {
	public static void main(String[] args) {
		String[][] arr = { { "you", "we" }, { "have", "are" } };
		System.out.println(sentences(arr));
	}

	public static ArrayList<ArrayList<String>> sentences(String[][] list) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		String[] output = new String[list.length];
		for (int i = 0; i < list[0].length; i++) {
			if (!list[0][i].equals(""))
				printUtil(list, 0, i, output, ans);
		}
		return ans;
	}

	public static void printUtil(String[][] arr, int m, int n, String[] output, ArrayList<ArrayList<String>> ans) {
		output[m] = arr[m][n];
		if (m == arr.length - 1) {
			ArrayList<String> temp = new ArrayList<>();
			for (int i = 0; i < arr.length; i++)
				temp.add(output[i]);
			ans.add(temp);
			return;
		}
		for (int i = 0; i < arr[0].length; i++) {
			if (m + 1 < arr.length && !arr[m + 1][i].equals("")) {
				printUtil(arr, m + 1, i, output, ans);
			}
		}
	}
}
