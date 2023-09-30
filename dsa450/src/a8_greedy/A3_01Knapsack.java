package a8_greedy;

/*
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
 * https://www.youtube.com/watch?v=bUSaenttI24
 */
public class A3_01Knapsack {
	public static void main(String[] args) {
		int cap = 4;
		int[] values = { 1, 2, 3 };
		int[] weight = { 4, 5, 1 };
		int ans = knapsack(cap, values, weight);
		System.out.println(ans);
	}

	private static int knapsack(int cap, int[] values, int[] weight) {
		int n = values.length;
		int[][] dp = new int[n + 1][cap + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (j > weight[i - 1]) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + values[i - 1]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}
}
