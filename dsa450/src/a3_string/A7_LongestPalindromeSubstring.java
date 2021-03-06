package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 * https://www.youtube.com/watch?v=WpYHNHofwjc
 * No formula, just travel on gap
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
	Example 1:
	Input:
	S = "aaaabbaa"
	Output: aabbaa
 */
public class A7_LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "ayaxzfbjbkrxiri";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count = 0;
		int palinBeginsAt = 0;
		for (int g = 0; g < s.length(); g++) {
			boolean doUpdate = true; // For same value of 'g' do not update 'palinBeginsAt' once it is already updated. This will return the substring which occurs first
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
					count = g + 1;
					if (doUpdate) {
						palinBeginsAt = i;
						doUpdate = false;
					}
				}
			}
		}
		System.out.println(s.substring(palinBeginsAt, palinBeginsAt + count));
	}

}
