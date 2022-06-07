package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 * https://www.youtube.com/watch?v=3YILP-PdEJA&t=4s
 */
public class E2_BuySellStockKTransactions {
	public static void main(String[] args) {
		// solution1(); // O(n^3)
		solution2(); // O(n^2)
	}

	private static void solution2() {
		int[] prices = { 9, 6, 7, 6, 3, 8 };
		int k = 3; // No of transactions

		int[][] dp = new int[k + 1][prices.length];

		for (int t = 1; t <= k; t++) { // t -> transaction
			int max = Integer.MIN_VALUE;
			for (int d = 1; d < prices.length; d++) { // d -> days
				if (dp[t - 1][d - 1] - prices[d - 1] > max) {
					max = dp[t - 1][d - 1] - prices[d - 1];
				}
				if (max + prices[d] > dp[t][d - 1]) {
					dp[t][d] = max + prices[d];
				} else {
					dp[t][d] = dp[t][d - 1];
				}
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}

	private static void solution1() {
		int[] prices = { 9, 6, 7, 6, 3, 8 };
		int k = 3; // No of transactions

		int[][] dp = new int[k + 1][prices.length];

		for (int t = 1; t <= k; t++) { // t -> transaction
			for (int d = 1; d < prices.length; d++) { // d -> days
				int max = dp[t][d - 1];

				for (int pd = 0; pd < d; pd++) { // pd -> previous day
					int ptilltm1t = dp[t - 1][pd]; // profit till t-1 transactions
					int pth = prices[d] - prices[pd]; // profit till t^th transaction

					if (ptilltm1t + pth > max) {
						max = ptilltm1t + pth;
					}
				}
				dp[t][d] = max;
			}
		}
		System.out.println(dp[dp.length - 1][dp[0].length - 1]);
	}
}
