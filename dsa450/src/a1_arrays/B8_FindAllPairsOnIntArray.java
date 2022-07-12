package a1_arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class B8_FindAllPairsOnIntArray {

	/*
	 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
	 * https://www.youtube.com/watch?v=0VHC1KVHH0U Given an array of N integers, and
	 * an integer K, find the number of pairs of elements in the array whose sum is
	 * equal to K. Example 1: Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2
	 * Explanation: arr[0] + arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
	 */
	public static void main(String[] args) {
		//solution1(); // https://www.youtube.com/watch?v=0VHC1KVHH0U Time and space - O(n)
		// solution2(); // https://www.youtube.com/watch?v=4t9jv9AkVdE&t=192s - Target sum pair when the input elements are unique
		solution3(); // https://www.youtube.com/watch?v=l5Ruk_Ub8B4 - Target sum unique pair, when the input elements can repeat
		// solution4(); // Cannot be done by using set. Failing test case - {1,5,5,5,5,7} and k=10. Correct op =6 and op from set=3
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
	
	private static void solution2() {
		int[] arr = { 1, 5, 7};
		int target = 6;
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int sum = arr[low] + arr[high];
			if (sum < target) {
				low++;
			} else if (sum > target) {
				high--;
			} else {
				System.out.print(arr[low] + " " + arr[high]);
				low++;
				high--;
			}
		}
	}
	
	private static void solution3() {
		int[] arr = { 2, 2, 4, 3, 1, 6, 6, 7, 5, 9, 1, 8, 9 };
		int target = 10;
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			if (low != 0 && arr[low] == arr[low - 1]) {
				low++;
				continue;
			}
			int sum = arr[low] + arr[high];
			if (sum < target) {
				low++;
			} else if (sum > target) {
				high--;
			} else {
				System.out.println(arr[low] + " " + arr[high]);
				low++;
				high--;
			}
		}
	}

	private static void solution4() {
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
