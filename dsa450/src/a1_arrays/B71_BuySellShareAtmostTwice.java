package a1_arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/buy-and-sell-a-share-at-most-twice/1
 * 	https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-share-at-most-twice/
 * 	https://www.geeksforgeeks.org/maximum-profit-by-buying-and-selling-a-stock-at-most-twice-set-2/?ref=rp
 * 	In daily share trading, a buyer buys shares in the morning and sells them on the same day. 
 * 	If the trader is allowed to make at most 2 transactions in a day, whereas the second transaction can only start after the first one is complete
 *  (Buy->sell->Buy->sell). Given stock prices throughout the day, find out the maximum profit that a share trader could have made.
	Input:   price[] = {10, 22, 5, 75, 65, 80}
	Output:  87
	Trader earns 87 as sum of 12, 75 
	Buy at 10, sell at 22, 
	Buy at 5 and sell at 80
 */
public class B71_BuySellShareAtmostTwice {

	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int a[] = {10, 22, 5, 75, 65, 80};
		int minPrice1 = Integer.MAX_VALUE;
		int minPrice2 = Integer.MAX_VALUE;
		int profit1 = Integer.MIN_VALUE;
		int profit2 = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			minPrice1 = Math.min(minPrice1, a[i]);
			profit1 = Math.max(profit1, a[i] - minPrice1);
			minPrice2 = Math.min(minPrice2, a[i] - profit1);
			profit2 = Math.max(profit2, a[i] - minPrice2);
		}
		System.out.println(profit2);
	}
}
