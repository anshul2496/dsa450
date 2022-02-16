package a1_arrays;

/*
 * https://www.techiedelight.com/maximum-profit-earned-buying-and-selling-shares/
 * Stock Prices: {1, 5, 2, 3, 7, 6, 4, 5}
	Total profit earned is 10
	Buy on day 1 and sell on day 2
	Buy on day 3 and sell on day 5
	Buy on day 7 and sell on day 8
 */
public class D9_BuyAndSellStockMuliTimes {
	public static void main(String[] args) {
		int[] price = { 1, 5, 2, 3, 7, 6, 4, 5 };
		// keep track of the maximum profit gained
        int profit = 0;
 
        // initialize the local minimum to the first element's index
        int j = 0;
 
        // start from the second element
        for (int i = 1; i < price.length; i++)
        {
            // update the local minimum if a decreasing sequence is found
            if (price[i - 1] > price[i]) {
                j = i;
            }
 
            // sell shares if the current element is the peak,
            // i.e., (`previous <= current > next`)
            if (price[i - 1] <= price[i] &&
                (i + 1 == price.length || price[i] > price[i + 1]))
            {
                profit += (price[i] - price[j]);
                System.out.printf("Buy on day %d and sell on day %d\n", j + 1, i + 1);
            }
        }
        System.out.println(profit);
	}
}
