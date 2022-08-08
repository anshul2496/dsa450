package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string1956/1
 * https://www.youtube.com/watch?v=WpYHNHofwjc
 * No formula, just travel on gap
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
	Example 1:
	Input:
	S = "aaaabbaa"
	Output: aabbaa
 */
public class A72_LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "aaaabbaa";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		int start = 0;
		int end = 0;
		int maxlen = 0;
		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int g = 0; g < dp[0].length; g++) {
			int len = 0;
			for (int i = 0, j = g; j < dp[0].length; i++, j++) {
				if (g == 0)
					dp[i][j] = true;
				else if (g == 1)
					dp[i][j] = s.charAt(i) == s.charAt(j);
				else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
						dp[i][j] = true;
				}
				if (dp[i][j]) {
					len = j - i + 1;
					if (maxlen < len) {
						maxlen = len;
						start = i;
						end = j;
					}
				}
			}
		}
		return s.substring(start, end + 1);
	}
}
