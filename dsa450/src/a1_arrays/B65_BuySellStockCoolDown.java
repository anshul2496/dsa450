package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * https://www.youtube.com/watch?v=GY0O57llkKQ
 * Infinite Transactions allowed with Cool Down. There has to be one day gap after sell
 * First buy then sell allowed 
 */
public class B65_BuySellStockCoolDown {
	public static void main(String[] args) {
		int[] a = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
		int obsp = -a[0];
		int ossp = 0;
		int ocsp = 0;
		for (int i = 1; i < a.length; i++) {
			int nbsp = 0;
			int nssp = 0;
			int ncsp = 0;
			nbsp = Math.max(obsp, ocsp - a[i]);
			nssp = Math.max(ossp, obsp + a[i]);
			ncsp = Math.max(ocsp, ossp);
			obsp = nbsp;
			ossp = nssp;
			ocsp = ncsp;
		}
		System.out.println(ossp);
	}
}
