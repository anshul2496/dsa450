package a1_arrays;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
 * Given an array of positive and negative numbers. Find if there is a subarray
 * (of size at-least one) with 0 sum.
 * Example 1: Input: 5 4 2 -3 1 6 Output: Yes Explanation: 2, -3, 1 is the
 * subarray with sum 0.
 */
public class C11_SubarrayWith0Sum {
	public static void main(String[] args) {
		int[] a = { 5, 4, 2, -3, 1, 6 };
		boolean ans = findsum(a, a.length); // Time : O(n) Space O(n)
		System.out.println(ans);
	}

	static boolean findsum(int a[], int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (map.containsKey(sum) || sum == 0)
				return true;
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return false;
	}
}
