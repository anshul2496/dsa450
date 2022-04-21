package a5_interviews;

/*
 * https://www.techiedelight.com/maximum-profit-earned-buying-and-selling-shares/
 * https://www.youtube.com/watch?v=HWJ9kIPpzXs&t=12s
 * Stock Prices: {1, 5, 2, 3, 7, 6, 4, 5}
	Total profit earned is 10
	Buy on day 1 and sell on day 2
	Buy on day 3 and sell on day 5
	Buy on day 7 and sell on day 8
 */
public class A1_BuyAndSellStockMuliTimes {
	public static void main(String[] args) {
		int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
		int profit = 0;
		int buyDate = 0;
		int sellDate = 0;
		for (int i = 1; i < price.length; i++) {
			if (price[i] >= price[i - 1]) {
				sellDate++;
			} else {
				profit += price[sellDate] - price[buyDate];
				buyDate = sellDate = i;
			}
		}
		// Collect last stroke profit
		profit += price[sellDate] - price[buyDate];
		System.out.println(profit);
	}
}
