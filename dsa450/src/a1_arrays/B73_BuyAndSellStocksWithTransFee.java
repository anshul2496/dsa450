package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * https://www.youtube.com/watch?v=pTQB9wbIpfU
 * Infinite Transactions allowed with Transaction fee
 * Transaction fee will be charged when you sell
 * First buy then sell allowed
 */
public class B73_BuyAndSellStocksWithTransFee {
	public static void main(String[] args) {
		int[] price = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
		int fee = 3;
		int oldBuyPrice = -price[0];
		int oldSellPrice = 0;
		for (int i = 1; i < price.length; i++) {
			int newBuyPrice = 0;
			int newSellPrice = 0;

			if (oldSellPrice - price[i] > oldBuyPrice) {
				newBuyPrice = oldSellPrice - price[i];
			} else {
				newBuyPrice = oldBuyPrice;
			}

			if (oldBuyPrice + price[i] - fee > oldSellPrice) {
				newSellPrice = oldBuyPrice + price[i] - fee;
			} else {
				newSellPrice = oldSellPrice;
			}
			oldBuyPrice = newBuyPrice;
			oldSellPrice = newSellPrice;
		}
		System.out.println(oldSellPrice);
	}
}
