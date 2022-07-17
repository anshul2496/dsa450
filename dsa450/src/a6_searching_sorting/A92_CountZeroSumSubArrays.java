package a6_searching_sorting;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
 * https://www.youtube.com/watch?v=C9-n_H7dsvU
 */
public class A92_CountZeroSumSubArrays {
	public static void main(String[] args) {
		int[] a = { 0, 0, 5, 5, 0, 0 };
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int i = 0;
		while (i < a.length) {
			sum += a[i];
			if (map.containsKey(sum)) {
				count += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
			i++;
		}
		System.out.println(count);
	}
}
