package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/longest-palindrome-in-a-string3411/1
 * https://www.youtube.com/watch?v=DK5OKKbF6GI
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
	static int resultStart = 0;
	static int resultLength = 0;
	
	public static void main(String[] args) {
		String s = "aaaabbaa";
		String longestPalin = getLongestPalindrome(s);
		System.out.println(longestPalin);
	}

	private static String getLongestPalindrome(String s) {
		int strLen = s.length();
		if (strLen == 0 || strLen == 1)
			return s;
		for (int start = 0; start < s.length() - 1; start++) {
			expandRange(s, start, start);
			//System.out.println(s.substring(resultStart, resultStart + resultLength));
			expandRange(s, start, start + 1);
			//System.out.println(s.substring(resultStart, resultStart + resultLength));
		}
		return s.substring(resultStart, resultStart + resultLength);
	}

	private static void expandRange(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && (s.charAt(begin) == s.charAt(end))) {
			begin--;
			end++;
		}
		int palinLength = end - begin - 1;
		if (resultLength < palinLength) {
			resultLength = palinLength;
			resultStart = begin + 1;
		}
	}
}
