package a3_string;

/*
 * https://leetcode.com/problems/palindromic-substrings/
 * https://www.youtube.com/watch?v=XmSOWnL6T_I
 * Formula - No formula, just travel on gap
 * Total Substrings - n(n+1)/2 = n^2 and you will do it n times(for each substring),
 * so brute force complexity is O(n^3)
 * Current approach dp - O(n^2) space and O(n^2) time
 * can also be done by Manequers algorithm in O(n)
 */
public class A71_CountPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abccbc";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count = 0;
		for (int g = 0; g < dp[0].length; g++) { // All diagonals start at the 1st row
			for (int i = 0, j = g; j < dp[0].length; i++, j++) { // All diagonals end at the last column
				if (g == 0) {
					dp[i][j] = true;
				} else if (g == 1) {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = true;
					}
				} else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
						dp[i][j] = true;
					}
				}
				if (dp[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
