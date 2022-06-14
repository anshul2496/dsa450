package a3_string;

/*
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * https://www.youtube.com/watch?v=RiNzHfoA2Lo&t=28s
 * Formula - Calculate all the palindromic subsequence and then find the longest
 * LongestPalindromicSubsequence`lps`(str) -> AllSubsequences`s`(str) ->  
 * s(c1mc2) -> 	_s(m)_ - 1			
 * 				c1s(m)_ - 2
 * 				_s(m)c2	-3
 * 				c1s(m)c2 -4
 * && 
 * s(c1m) = _s(m) + c1s(m)
 * s(mc2) = s(m)_ + s(m)c2
 * if c1==c2  Answer is in 4 which is = 2+ lps(m)
 * if c1!=c2  Answer is in 1,2,3 which is Max(lps(c1m),lps(mc2))
 * ***** Travel on gap for palindrome type questions*****
 * Input: s = "bbbab"
	Output: 4
	Explanation: One possible longest palindromic subsequence is "bbbb".
 */
public class A71_LongestPalindromicSubsequence {
	public static void main(String[] args) {
		String s = "bbbab";
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
		System.out.println(dp[0][s.length() - 1]);
	}
}
