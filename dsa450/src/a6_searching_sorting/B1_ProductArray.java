package a6_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1
 * https://www.youtube.com/watch?v=UBkpyXgx0g0
 */
public class B1_ProductArray {
	public static void main(String[] args) {
		int[] a = { 10, 3, 5, 6, 2 };
		int[] ans = new int[a.length];
		int[] right = new int[a.length];
		int prod = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			prod *= a[i];
			right[i] = prod;
		}

		prod = 1;
		int lp = 1, rp = 1;
		for (int i = 0; i < a.length - 1; i++) {
			lp = prod;
			rp = right[i + 1];
			ans[i] = lp * rp;
			prod *= a[i];
		}
		ans[a.length - 1] = prod;
		System.out.println(Arrays.toString(ans));
	}
}
