package a8_greedy;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
 * https://www.youtube.com/watch?v=nFxKOjT8270
 */
public class A8_ShopInCandyStore {
	public static void main(String[] args) {
		int[] candies = { 3, 2, 1, 4 };
		int k = 2;
		ArrayList<Integer> list = candyStore(candies, k);
		System.out.println(list);
	}

	static ArrayList<Integer> candyStore(int candies[], int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		int min = 0;
		int max = 0;
		Arrays.sort(candies);
		int i = 0;
		int j = candies.length - 1;
		while (i <= j) {
			min += candies[i];
			j -= k;
			i++;
		}
		i = 0;
		j = candies.length - 1;
		while (i <= j) {
			max += candies[j];
			i += k;
			j--;
		}
		ans.add(min);
		ans.add(max);
		return ans;
	}
}
