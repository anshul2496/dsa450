package a8_greedy;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/problems/buy-maximum-stocks-if-i-stocks-can-be-bought-on-i-th-day/1
 * https://www.youtube.com/watch?v=F8k226GM8Dg
 */
public class A7_IStocksIthDay {
	public static void main(String[] args) {
		int n = 3;
		int k = 45;
		int[] price = { 10, 7, 19 };
		System.out.println(buyMaximumProducts(n, k, price));
	}

	public static int buyMaximumProducts(int n, int k, int[] price) {
		int ans = 0;
		Pair[] pair = new Pair[n];
		for (int i = 0; i < n; i++) {
			pair[i] = new Pair(i + 1, price[i]);
		}
		Arrays.sort(pair);
		for (int i = 0; i < n; i++) {
			if (k > 0) {
				ans += Math.min(k / pair[i].price, pair[i].day);
				k -= (pair[i].price * pair[i].day);
			}
		}
		return ans;
	}
}

class Pair implements Comparable<Pair> {
	int price;
	int day;

	public Pair(int day, int price) {
		this.day = day;
		this.price = price;
	}

	public int compareTo(Pair other) {
		return this.price - other.price;
	}
}