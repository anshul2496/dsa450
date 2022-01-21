package a1_arrays;

public class C4_MaxProductSubarray {

	/*
	 * https://practice.geeksforgeeks.org/problems/maximum-product-subarray3604/1
	 * https://www.youtube.com/watch?v=jzQ-f2uU0UU Given an array Arr that contains
	 * N integers (may be positive, negative or zero). Find the product of the
	 * maximum product subarray. Example 1: Input: N = 5 Arr[] = {6, -3, -10, 0, 2}
	 * Output: 180 Explanation: Subarray with maximum product is 6, -3, -10 which
	 * gives product as 180.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 6, -3, -10, 0, 2 };
		int max_so_far = Integer.MIN_VALUE;
		int max_till_now = 1;
		for (int i = 0; i < a.length; i++) {
			max_till_now = max_till_now * a[i];
			if (max_so_far < max_till_now) {
				max_so_far = max_till_now;
			}
			if (max_till_now == 0) {
				max_till_now = 1;
			}
		}
		max_till_now = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			max_till_now = max_till_now * a[i];
			if (max_so_far < max_till_now) {
				max_so_far = max_till_now;
			}
			if (max_till_now == 0) {
				max_till_now = 1;
			}
		}
		System.out.println(max_so_far);
	}

}
