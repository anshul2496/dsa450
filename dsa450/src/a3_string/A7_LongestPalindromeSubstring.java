package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 * https://www.youtube.com/watch?v=WpYHNHofwjc
 * Given a string S, find the longest palindromic substring in S. Substring of string S: S[ i . . . . j ] where 0 ≤ i ≤ j < len(S). 
 * Palindrome string: A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S. 
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
	Example 1:
	Input:
	S = "aaaabbaa"
	Output: aabbaa
	Explanation: The longest Palindromic substring is "aabbaa".
	
	Example 2:
	Input: 
	S = "abc"
	Output: a
	Explanation: "a", "b" and "c" are the 
	longest palindromes with same length.The result is the one with the least starting index.
 */
public class A7_LongestPalindromeSubstring {
	public static void main(String[] args) {
		String s = "banana";
		boolean[][] dp = new boolean[s.length()][s.length()];
		int count = 0;
		int palinBeginsAt = 0;
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
					count = g + 1;
					palinBeginsAt = i;
				}
			}
		}
		System.out.println(s.substring(palinBeginsAt, count + 1));
	}

}
