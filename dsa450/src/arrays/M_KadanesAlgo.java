package arrays;

public class M_KadanesAlgo {

	/*
	 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
	 * Given an array arr of N integers. Find the contiguous sub-array with maximum
	 * sum.
	 * Example 1:
	 * Input: N = 5 arr[] = {1,2,3,-2,5} Output: 9 Explanation: Max subarray sum is
	 * 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 1, 2, 3, -2, 5 };
		int max_so_far = Integer.MIN_VALUE;
		int max_till_now = 0;
		for (int i = 0; i < a.length; i++) {
			max_till_now = max_till_now + a[i];
			if (max_so_far < max_till_now) {
				max_so_far = max_till_now;
			}
			if (max_till_now < 0) {
				max_till_now = 0;
			}
		}
		System.out.println(max_so_far);
	}
}
