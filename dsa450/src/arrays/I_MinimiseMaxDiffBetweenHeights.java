package arrays;

import java.util.Arrays;

public class I_MinimiseMaxDiffBetweenHeights {

	/*
	 * Given an array arr[] denoting heights of N towers and a positive integer K,
	 * you have to modify the height of each tower either by increasing or
	 * decreasing them by K only once. After modifying, height should be a
	 * non-negative integer. Find out what could be the possible minimum difference
	 * of the height of shortest and longest towers after you have modified each
	 * tower. Example 1: Input: K = 2, N = 4 Arr[] = {1, 5, 8, 10} Output: 5
	 * Explanation: The array can be modified as {3, 3, 6, 8}. The difference
	 * between the largest and the smallest is 8-3 = 5.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 1, 5, 8, 10 };
		int k = 2;
		int n = a.length;
		Arrays.sort(a);
		int ans = a[n - 1] - a[0];
		int small = a[0] + k;
		int big = a[n - 1] - k;
		int min;
		int max;
		for (int j = 1; j < n; j++) {
			if (a[j] >= k) {
				min = Math.min(a[j] - k, small);
				max = Math.max(a[j - 1] + k, big);
				ans = Math.min(ans, max - min);
			}
		}
		System.out.println(ans);
	}

}
