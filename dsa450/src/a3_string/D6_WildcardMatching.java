package a3_string;

/*
 * https://leetcode.com/problems/wildcard-matching/
 * https://www.youtube.com/watch?v=NbgUZAoIz3g&t=26s
 */
public class D6_WildcardMatching {
	public static void main(String[] args) {
		String str = "baaabab";
		String pattern = "ba*a?";
		boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1) { // Last cell
					dp[i][j] = true;
				} else if (i == dp.length - 1) { // Last row
					dp[i][j] = false;
				} else if (j == dp[0].length - 1) { // Last column
					if (pattern.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					} else {
						dp[i][j] = false;
					}
				} else { // Rest of the matrix
					if (pattern.charAt(i) == '?') {
						dp[i][j] = dp[i + 1][j + 1];
					} else if (pattern.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
					} else if (pattern.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i + 1][j + 1];
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		System.out.println(dp[0][0]);
	}
}
