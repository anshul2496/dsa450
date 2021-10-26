package arrays;

/*
 * 	https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-stock-at-most-twice-set-2/?ref=rp
 * 	In daily share trading, a buyer buys shares in the morning and sells them on the same day. 
 * 	If the trader is allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first one is complete
 *  (Buy->sell->Buy->sell). Given stock prices throughout the day, find out the maximum profit that a share trader could have made.
	Examples: 
	Input:   price[] = {10, 22, 5, 75, 65, 80}
	Output:  87
	Trader earns 87 as sum of 12, 75 
	Buy at 10, sell at 22, 
	Buy at 5 and sell at 80
 */
public class C8_BuySellShareAtmostTwice {

	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		int buy1, profit1, buy2, profit2;
		buy1 = buy2 = Integer.MAX_VALUE;
		profit1 = profit2 = 0;
		for (int i = 0; i < price.length; i++) {
			if (price[i] < buy1)
				buy1 = price[i];
			profit1 = Math.max(profit1, price[i] - buy1);
			if (price[i] - profit1 < buy2)
				buy2 = price[i] - profit1;
			profit2 = Math.max(profit2, price[i] - buy2);
		}
		System.out.println(profit2);
	}
}
