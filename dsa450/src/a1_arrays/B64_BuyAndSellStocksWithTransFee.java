package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * https://www.youtube.com/watch?v=pTQB9wbIpfU
 * Infinite Transactions allowed with Transaction fee
 * Transaction fee will be charged when you sell
 * First buy then sell allowed
 */
public class B64_BuyAndSellStocksWithTransFee {
	public static void main(String[] args) {
		int[] a = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
		int fee = 3;
		int obsp = -a[0]; // Old bought state profit
		int ossp = 0; // Old sold state profit
		for (int i = 1; i < a.length; i++) {
			int nbsp = 0;
			int nssp = 0;
			nbsp = Math.max(obsp, ossp - a[i]);
			nssp = Math.max(ossp, obsp + a[i] - fee);
			obsp = nbsp;
			ossp = nssp;
		}
		System.out.println(ossp);
	}
}
