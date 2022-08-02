package a1_arrays;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
 * https://www.youtube.com/watch?v=C9-n_H7dsvU
 */
public class C22_CountSubArrayWith0Sum {
	public static void main(String[] args) {
		int[] a = { 0, 0, 5, 5, 0, 0 };
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			if (map.containsKey(sum) || sum == 0)
				count += map.get(sum);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(count);
	}
}
