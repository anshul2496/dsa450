package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
 * https://www.youtube.com/watch?v=YHSjvswCXC8
 * Given a string str of length N, you have to find number of palindromic subsequence (need not necessarily be distinct) which could be formed from the string str.
	Note: You have to return the answer module 109+7;
	Example 1:
	Input: 
	Str = "abcd"
	Output: 
	4
	Explanation:
	palindromic subsequence are : "a" ,"b", "c" ,"d"
 */
public class B9_CountAllPalindromicSubseq {
	public static void main(String[] args) {
		String str = "abcd";
		int[][] dp = new int[str.length()][str.length()];
		for (int g = 0; g < str.length(); g++) {
			for (int i = 0, j = g; j < str.length(); i++, j++) {
				if (g == 0) {
					dp[i][j] = 1;
				} else if (g == 1) {
					dp[i][j] = str.charAt(i) == str.charAt(j) ? 3 : 2;
				} else {
					if (str.charAt(i) == str.charAt(j)) {
						dp[i][j] = dp[i][j - 1] + dp[i + 1][j] + 1; // Prefix+Suffix+1
					} else {
						dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]; // Prefix+Suffix-Subseq(middle)
					}
				}
			}
		}
		System.out.println(dp[0][str.length() - 1]);
	}
}
