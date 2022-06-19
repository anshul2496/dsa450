package a1_arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class C2_SubarrayWith0Sum {

	/*
	 * https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1
	 * 
	 * Given an array of positive and negative numbers. Find if there is a subarray
	 * (of size at-least one) with 0 sum.
	 * 
	 * Example 1: Input: 5 4 2 -3 1 6 Output: Yes Explanation: 2, -3, 1 is the
	 * subarray with sum 0.
	 */
	public static void main(String[] args) {
		// solution1(); // Time : O(n) Space O(n)
		solution2(); // Count of zero sum subarray -> https://www.youtube.com/watch?v=C9-n_H7dsvU
		// https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
	}

	private static void solution2() {
		int[] a = { 5, 4, 2, -3, 1, 6 };
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
		System.out.println(count);
	}

	private static void solution1() {
		int[] a = { 5, 4, 2, -3, 1, 6 };
		int sum = 0;
		Set<Integer> set = new HashSet<>();
		int flag = 0;
		for (int i = 0; i < a.length; i++) {
			sum = sum + a[i];
			if (sum == 0 || a[i] == 0 || set.contains(sum)) {
				System.out.println("yes");
				flag = 1;
				break;
			}
			set.add(sum);
		}
		if (flag == 0) {
			System.out.println("no");
		}
	}
}
