package a1_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
		solution1(); // This is for a different(similar problem). Check below method for current problem soln
		// When the elements repeat and you have to give count of repeating elements, it
		// cannot be done via sorting the array. You have to use frequency map
	}

	public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			if (low != 0 && arr[low] == arr[low - 1]) {
				low++;
				continue;
			}
			int sum = arr[low] + arr[high];
			if (sum < 0) {
				low++;
			} else if (sum > 0) {
				high--;
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(arr[low]);
				temp.add(arr[high]);
				ans.add(temp);
				low++;
				high--;
			}
		}
		return ans;
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
}
