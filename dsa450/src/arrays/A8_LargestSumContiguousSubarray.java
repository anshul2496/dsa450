package arrays;

public class A8_LargestSumContiguousSubarray {

	/*
	 * https://practice.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
	 * Kadane's Algo Given an array arr of N integers. Find the contiguous sub-array
	 * with maximum sum.
	 * Example 1:
	 * Input: N = 5 
	 * arr[] = {1,2,3,-2,5} 
	 * Output: 9 
	 * Explanation: Max subarray sum is
	 * 9 of elements (1, 2, 3, -2, 5) which is a contiguous subarray.
	 */
	public static void main(String[] args) {
		solution1_kadanesAlgorithm(); //O(n)
	}

	/*
	 * Explanation: The simple idea of Kadane's algorithm is to look for all
	 * positive contiguous segments of the array (max_ending_here is used for this).
	 * And keep track of maximum sum contiguous segment among all positive segments
	 * (max_so_far is used for this). Each time we get a positive-sum compare it
	 * with max_so_far and update max_so_far if it is greater than max_so_far
	 */
	private static void solution1_kadanesAlgorithm() {
		int[] a = { 1, 2, 3, -2, 5 };
		int max_so_far = Integer.MIN_VALUE;
		int max_ending_here = 0;
		for (int i = 0; i < a.length; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}
			if (max_ending_here < 0) {
				max_ending_here = 0;
			}
		}
		System.out.println("Max contigious sum = " + max_so_far);
	}

}
