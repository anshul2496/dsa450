package arrays;

import java.util.Arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together4847/1
 * 	Given an array arr of n positive integers and a number k. One can apply a swap operation on the array any number of times, 
 * 	i.e choose any two index i and j (i < j) and swap arr[i] , arr[j] . Find the minimum number of swaps required to bring all the numbers less than or equal to k together, 
 * 	i.e. make them a contiguous subarray.
	Example 1:
	Input : 
	arr[ ] = {2, 1, 5, 6, 3} 
	K = 3
	Output : 
	1
	Explanation:
	To bring elements 2, 1, 3 together,
	swap index 2 with 4 (0-based indexing),
	i.e. element arr[2] = 5 with arr[4] = 3
	such that final array will be- 
	arr[] = {2, 1, 3, 6, 5}
 */
public class D6_MinimumSwapsRequiredKTgether {
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		int[] arr = { 2, 7, 9, 5, 8, 7, 4 };
		int k = 6;
		int count = 0;
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			if (arr[i] <= k)
				++count;
		int bad = 0;
		for (int i = 0; i < count; ++i)
			if (arr[i] > k)
				++bad;
		int ans = bad;
		for (int i = 0, j = count ; j < n; ++i, ++j) {
			// Decrement count of previous window
			if (arr[i] > k)
				--bad;
			// Increment count of current window
			if (arr[j] > k)
				++bad;
			// Update ans if count of 'bad' is less in current window
			ans = Math.min(ans, bad);
		}
		System.out.println(ans);
	}

	private static void solution1() {
		int[] a = { 2, 7, 9, 5, 8, 7, 4 };
		int swaps = 0;
		int k = 6;
		int low = 0;
		int high = a.length - 1;
		while (low < high) {
			if (a[low] < k) {
				low++;
			} else if (a[low] > k && a[high] < k) {
				int temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				swaps++;
				high--;
				low++;
			} else if (a[low] > k && a[high] > k) {
				high--;
			}
		}
		System.out.println(Arrays.toString(a));
		System.out.println(swaps);
	}
}
