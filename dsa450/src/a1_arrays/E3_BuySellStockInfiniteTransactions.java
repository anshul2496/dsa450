package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * https://www.youtube.com/watch?v=HWJ9kIPpzXs
 */
public class E3_BuySellStockInfiniteTransactions {
	public static void main(String[] args) {
		int[] a = { 7, 1, 5, 3, 6, 4 };
		int bd = 0;
		int sd = 0;
		int profit = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] >= a[i - 1])
				sd++;
			else {
				profit += a[sd] - a[bd];
				sd = bd = i;
			}
		}
		profit += a[sd] - a[bd]; // For the last stroke profit will not be collected in the above loop if no dip
									// comes at the end
		System.out.println(profit);
	}
}
