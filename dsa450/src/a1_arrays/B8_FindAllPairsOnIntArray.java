package a1_arrays;

import java.util.HashMap;

public class B8_FindAllPairsOnIntArray {

	/*
	 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
	 * https://www.youtube.com/watch?v=0VHC1KVHH0U Given an array of N integers, and
	 * an integer K, find the number of pairs of elements in the array whose sum is
	 * equal to K. Example 1: Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2
	 * Explanation: arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
	 */
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		int[] arr = { 1, 5, 7, 1 };
		int sum = 6;
		int count = 0;
		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int rem = sum - arr[i];
			if (mp.containsKey(rem)) {
				count = count + mp.get(rem);
			}
			if (mp.containsKey(arr[i])) {
				mp.put(arr[i], mp.get(arr[i]) + 1);
			} else {
				mp.put(arr[i], 1);
			}
		}
		System.out.println(count);
	}

	private static void solution1() {
		int[] a = { 1, 5, 7, 1 };
		int k = 6;
		int i = 0;
		int count = 0;
		int j = a.length - 1;
		while (i < a.length - 1) {
			if (a[i] + a[j] == k) {
				count++;
			}
			j--;
			if (j == i) {
				i++;
				j = a.length - 1;
			}
		}
		System.out.println(count);
	}
}
