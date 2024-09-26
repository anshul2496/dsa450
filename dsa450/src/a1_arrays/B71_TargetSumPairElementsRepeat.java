package a1_arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
 * https://www.youtube.com/watch?v=0VHC1KVHH0U 
 * Given an array of N integers, and an integer K, find the number of pairs of elements in the array whose sum is
 * equal to K. Example 1: Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2
 * Explanation: arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
 */
public class B71_TargetSumPairElementsRepeat {
	public static void main(String[] args) {
		// Frequency Map - O(n), O(n)
		solution1();
		// When the elements repeat and you have to give count of repeating elements, it
		// cannot be done via sorting the array. You have to use frequency map
	}

	private static void solution1() {
		int[] arr = { 1, 5, 7, 1 };
		int sum = 6;
		int count = 0;
		HashMap<Integer, Integer> mp = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			int rem = sum - arr[i];
			if (mp.containsKey(rem)) {
				count = count + mp.get(rem);
			}
			mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
		}
		System.out.println(count);
	}

	// Cannot be done by using set. Failing test case - {1,5,5,5,5,7} and k=10.
	// Correct op =6 and op from set=3
	private static void solution2() {
		int[] arr = { 1, 5, 7, 1 };
		int sum = 6;
		int count = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			int rem = sum - arr[i];
			if (set.contains(rem)) {
				count++;
			}
			set.add(arr[i]);
		}
		System.out.println(count);
	}
}
