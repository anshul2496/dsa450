package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
 * https://www.youtube.com/watch?v=0Ql40Llp09E
 * c1 -> first character
 * r1 -> rest of the string for s1
 * lcs(s1,s2) = lcs(c1r1,c2r2) = s(c1r1) * s(c2r2) = _s(r1) * _s(r2) - 1
					  							   = _s(r1) * c2s(r2) - 2
					  							   = c1s(r1) * _s(r2)  - 3
					  							   = c1s(r1) * c2s(r2) - 4	
	lcs(s1,r2) = 1 and 3
	lcs(r1,s2) = 1 and 2				  							   
 * lcs(s1,s2) = 1+lcs(r1,r2) if c1==c2
 * lcs(s1,s2) = max(lcs(r1,s2), lcs(s1,r2))  if c1!=c2
 * **Bottom up approach for lcs****
 */
public class A8_LongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "ab";
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = dp.length - 2; i >= 0; i--) {
			for (int j = dp[0].length - 2; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					dp[i][j] = 1 + dp[i + 1][j + 1];
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
				}
			}
		}
		System.out.println(dp[0][0]);
	}
}
