package a1_arrays;

public class B1_MinJumpsToReachArrayEnd {
	/*
	 * https://practice.geeksforgeeks.org/problems/minimum-number-of-jumps-
	 * 1587115620/1 Given an array of N integers arr[] where each element represents
	 * the max number of steps that can be made forward from that element. Find the
	 * minimum number of jumps to reach the end of the array (starting from the
	 * first element). If an element is 0, then you cannot move through that
	 * element. Example 1: Input: N = 11 arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
	 * Output: 3 Explanation: First jump from 1st element to 2nd element with value
	 * 3. Now, from here we jump to 5th element with value 9, and from here we will
	 * jump to last.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] arr = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		if (arr[0] == 0)
			System.out.println("Jump not possible");
		int maxReach = 0, step = 0, jump = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			maxReach = Math.max(maxReach, i + arr[i]);
			if (i == step) {
				step = maxReach;
				jump++;
			}
		}
		if (step >= arr.length - 1) {
			System.out.println("Jumps needed = " + jump);
		} else {
			System.out.println("Jump not possible");
		}
	}
}
