package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1/
 * https://www.youtube.com/watch?v=tRpkluGqINc
 */
public class C4_SubsetSum {
	public static void main(String[] args) {
		int[] a = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;
		boolean[][] dp = new boolean[a.length + 1][sum + 1];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else if (j == 0) {
					dp[i][j] = true;
				} else {
					if (dp[i - 1][j] == true)
						dp[i][j] = true;
					else {
						int val = a[i - 1];
						if (j >= val) {
							if (dp[i - 1][j - val] == true)
								dp[i][j] = true;
						}
					}
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}
}
