package arrays;

public class B7_BuyAndSellStock {

	/*
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
	 * 
	 * You are given an array prices where prices[i] is the price of a given stock
	 * on the ith day.
	 * You want to maximize your profit by choosing a single day to buy one stock
	 * and choosing a different day in the future to sell that stock.
	 * Return the maximum profit you can achieve from this transaction. If you
	 * cannot achieve any profit, return 0.
	 * Example 1:
	 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1)
	 * and sell on day 5 (price = 6), profit = 6-1 = 5. Note that buying on day 2
	 * and selling on day 1 is not allowed because you must buy before you sell.
	 */
	public static void main(String[] args) {
		//solution1(); //O(n^2)
		solution2(); //O(n)
	}

	private static void solution2() {
		int[] a = { 7, 1, 5, 3, 6, 4 };
		int minPrice = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < minPrice) {
				minPrice = a[i];
			} else if (a[i] - minPrice > maxProfit) {
				maxProfit = a[i] - minPrice;
			}
		}
		System.out.println(maxProfit);
	}

	private static void solution1() {
		int[] a = { 7, 1, 5, 3, 6, 4 };
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					max = Math.max(max, a[j] - a[i]);
				}
			}
		}
		System.out.println(max);
	}
}
