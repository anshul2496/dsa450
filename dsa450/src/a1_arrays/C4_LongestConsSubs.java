package a1_arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * 	https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 * 	Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the 
 * 	subsequence are consecutive integers, the consecutive numbers can be in any order.
	Input:
	N = 7
	a[] = {2,6,1,9,4,5,3}
	Output:
	6
	Explanation:
	The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 */
public class C4_LongestConsSubs {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
		int max = 0;
		int count = 0;
		int minVal = Integer.MAX_VALUE;
		int maxVal = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		// Map lookups are faster and hence we dont get TLE in test cases of gfg.
		// If we use ArrayList or Set, then .contains() gives TLE, so we use containsKey() which is faster
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], 1);
			minVal = Math.min(minVal, arr[i]);
			maxVal = Math.max(maxVal, arr[i]);
		}
		for (int i = minVal; i <= maxVal; i++) {
			if (map.containsKey(i))
				count++;
			else
				count = 0;
			max = Math.max(max, count);
		}
		System.out.println(max);
	}
}
