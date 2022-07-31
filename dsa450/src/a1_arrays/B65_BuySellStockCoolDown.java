package a1_arrays;

/*
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * https://www.youtube.com/watch?v=GY0O57llkKQ
 * Infinite Transactions allowed with Cool Down. There has to be one day gap after sell
 * First buy then sell allowed 
 */
public class B65_BuySellStockCoolDown {
	public static void main(String[] args) {
		int[] price = { 10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25 };
		int oldBuyPrice = -price[0];
		int oldSellPrice = 0;
		int oldCoolPrice = 0;

		for (int i = 1; i < price.length; i++) {
			int newBuyPrice = 0;
			int newSellPrice = 0;
			int newCoolPrice = 0;

			if (oldCoolPrice - price[i] > oldBuyPrice) {
				newBuyPrice = oldCoolPrice - price[i];
			} else {
				newBuyPrice = oldBuyPrice;
			}

			if (oldBuyPrice + price[i] > oldSellPrice) {
				newSellPrice = oldBuyPrice + price[i];
			} else {
				newSellPrice = oldSellPrice;
			}

			if (oldSellPrice > oldCoolPrice) {
				newCoolPrice = oldSellPrice;
			} else {
				newCoolPrice = oldCoolPrice;
			}

			oldBuyPrice = newBuyPrice;
			oldSellPrice = newSellPrice;
			oldCoolPrice = newCoolPrice;
		}
		System.out.println(oldSellPrice);
	}
}
