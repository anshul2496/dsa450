package a1_arrays;

import java.util.Arrays;

/*
 * https://classroom.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/2-sum-target-sum-unique-pairs/ojquestion#!
 * https://www.youtube.com/watch?v=l5Ruk_Ub8B4
 * Target sum unique pair, when the input elements can repeat
 */
public class B73_TargetSumUniquePairs {
	public static void main(String[] args) {
		int[] arr = { 2, 2, 4, 3, 1, 6, 6, 7, 5, 9, 1, 8, 9 };
		int target = 10;
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
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
}
