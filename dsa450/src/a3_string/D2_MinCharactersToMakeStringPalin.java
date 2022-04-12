package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1/
 * https://www.youtube.com/watch?v=IP4iqrh0mQk&t=225s
 */
public class D2_MinCharactersToMakeStringPalin {
	public static void main(String[] args) {
		String s = "abcd";
		int[][] dp = new int[s.length()][s.length()];
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
				} else {
					if (s.charAt(i) == s.charAt(j)) {
						dp[i][j] = 2 + dp[i + 1][j - 1];
					} else {
						dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
					}
				}
			}
		}
		System.out.println(s.length() - dp[0][s.length() - 1]);
	}
}
