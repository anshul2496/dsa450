package a3_string;

/* https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1
 * https://www.youtube.com/watch?v=oL7GCrcdaJI
 * Given a string str, find the length of the longest repeating subsequence such that it can be found twice in the given string. 
 * The two identified subsequences A and B can use the same ith character from string str if and only if that ith character has different indices in A and B.
	Example 1:
	Input:
	str = "abacbc"
	Output: 2
	Explanation:
	abc
	(All a,b and c are at different indices)
 */
public class A9_LongestRepeatingSubs {
	public static void main(String[] args) {
		String s = "abacbc";
		int[][] dp = new int[s.length() + 1][s.length() + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (s.charAt(i) == s.charAt(j) && i != j) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}
}
