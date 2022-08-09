package a3_string;

/*
 * https://www.pepcoding.com/resources/online-java-foundation/recursion-on-the-way-up/print-subsequence-official/ojquestion
 * https://www.geeksforgeeks.org/print-subsequences-string/
 * https://www.youtube.com/watch?v=Ke8TPhHdHMw
 * Given a string, we have to find out all subsequences of it. A String is a subsequence of a given String, 
 * that is generated by deleting some character of a given string without changing its order.
	Examples: 
	Input : abc
	Output : a, b, c, ab, bc, ac, abc
 */
public class B1_PrintSubsequence {
	public static void main(String[] args) {
		String str = "abc";
		printSubsequence(str, "");// Time - O(n) : Space  - No extra space used. Only recursive stack space
	}

	private static void printSubsequence(String str, String ans) {
		if (str.length() == 0) {
			System.out.println(ans);
			return;
		}
		char ch = str.charAt(0);
		String restOfString = str.substring(1);
		printSubsequence(restOfString, ans + ch);
		printSubsequence(restOfString, ans + "");
	}
}
