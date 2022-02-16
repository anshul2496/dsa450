package a3_string;

/*
 * https://www.youtube.com/watch?v=XmSOWnL6T_I
 */
public class A61_CountPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abccbc";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count = 0;
		for (int g = 0; g < s.length(); g++) {
			for (int i = 0, j = g; j < dp.length; i++, j++) {
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
