package a3_string;

/*
 * https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
 * https://www.youtube.com/watch?v=YHSjvswCXC8
 *  * CountPalindromicSubsequence`c`(str) -> AllSubsequences`s`(str) ->  
 * s(c1mc2) -> 	_s(m)_  
 * 				c1s(m)_ 
 * 				_s(m)c2	
 * 				c1s(m)c2 
 * && 
 * c(c1m)= s(c1m) = _s(m) + c1s(m)
 * c(mc2)= s(mc2) = s(m)_ + s(m)c2
 * Now,
 * c(c1mc2) -> c[_s(m)_] - c1'		
 * 				c[c1s(m)_] - c2'
 * 				c[_s(m)c2]	-c3'
 * 				c[c1s(m)c2] - c4'
 * if c1==c2  Answer is in c1'+c2'+c3'+c4' = c1'+c2'+c3'+(c1'+1) = (c1'+c2')+(c1'+c3')+1 = 1+c(c1m)+c(mc2)
 * if c1!=c2  Answer is in c1'+c2'+c3' = c1'+c2'+c3'+c1'-c1'=(c1'+c2')+(c1'+c3')-c1'= c(c1m)+c(mc2)-c(m)
 * Brute force - Total subsequences=2^n and to check whether each subseq is palin or not we need n more
 * So, total Time Complexity=O(n2^n)
 */
public class A82_CountAllPalindromicSubseq {
	public static void main(String[] args) {
		// Solved using gap technique
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
