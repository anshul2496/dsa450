package a3_string;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1
 * https://www.youtube.com/watch?v=svMdY6wlQ6I
 */
public class B9_CountSubarraysEqual0and1 {
	public static void main(String[] args) {
		int[] a = { 1, 0, 0, 1, 0, 1, 1 };
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				sum += -1;
			else
				sum += 1;
			if (map.containsKey(sum)) {
				count += map.get(sum);
			}
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		System.out.println(count);
	}
}
