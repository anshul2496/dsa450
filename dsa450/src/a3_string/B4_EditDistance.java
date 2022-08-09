package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/edit-distance3702/1
 * https://www.youtube.com/watch?v=tooMn-xfYCU
 * Given two strings s and t. Return the minimum number of operations required to convert s to t.
	The possible operations are permitted:
	Insert a character at any position of the string.
	Remove any character from the string.
	Replace any character from the string with any other character.
	Example 1:
	Input: 
	s = "geek", t = "gesek"
	Output: 1
	Explanation: One operation is required 
	inserting 's' between two 'e's of str1.
 */
public class B4_EditDistance {
	public static void main(String[] args) {
		String str1 = "geek";
		String str2 = "gesek";
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0) {
					dp[i][j] = j;
				} else if (j == 0) {
					dp[i][j] = i;
				} else {
					if (str1.charAt(i - 1) == str2.charAt(j - 1)) { // bec. we are starting from blank so "-1" for string character
						dp[i][j] = dp[i - 1][j - 1];
					} else {
						int f1 = dp[i - 1][j - 1]; // replace
						int f2 = dp[i][j - 1]; // insert
						int f3 = dp[i - 1][j]; // delete
						dp[i][j] = Math.min(f2, Math.min(f1, f3)) + 1;
					}
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}
}
