package a1_arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1
 * https://www.youtube.com/watch?v=GLpB03voaCs
 * 	Given an array of integers (A[])  and a number x, find the smallest subarray with sum greater than the given value.
	Note: The answer always exists. It is guaranteed that x doesn't exceed the summation of a[i] (from 1 to N).
	Example 1:
	Input:
	A[] = {1, 4, 45, 6, 0, 19}
	x  =  51
	Output: 3
	Explanation:
	Minimum length subarray is 
	{4, 45, 6}
	
	Example 2:
	Input:
	A[] = {1, 10, 5, 2, 7}
	x  = 9
	Output: 1
	Explanation:
	Minimum length subarray is {10}
 */
public class D4_SmallestSubarrayWithSumGreater {
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		int[] a = { 1, 4, 45, 6, 0, 19 };
		int x = 51;
		int n = a.length;
		int ans = Integer.MAX_VALUE;
		int start = 0;
		int end = 1;
		int sum = a[start];
		if (sum > x)
			System.out.println(1);
		if (end < n)
			sum += a[end];

		while (start < n && end < n) {
			if (sum > x) {
				ans = Math.min(ans, end - start + 1);
				sum -= a[start];
				start++;
			} else {
				end++;
				if (end < n) {
					sum += a[end];
				}
			}
		}
		System.out.println(ans);
	}

	private static void solution1() {
		int[] a = { 1, 4, 45, 6, 0, 19 };
		int x = 51;
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				if (sum > x) {
					minLength = Math.min(minLength, j - i + 1);
					break;
				}
			}
		}
		System.out.println(minLength);
	}
}
