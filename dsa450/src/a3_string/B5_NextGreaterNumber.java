package a3_string;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/next-permutation5226/1
 * same as arrays B6 -> https://leetcode.com/problems/next-permutation/solution/
 * Input: N = 6
	arr = {1, 2, 3, 6, 5, 4}
	Output: {1, 2, 4, 3, 5, 6}
	Explaination: The next permutation of the 
	given array is {1, 2, 4, 3, 5, 6}.
 */
public class B5_NextGreaterNumber {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 6, 5, 4 };
		int i = a.length - 2;
		while (i >= 0 && a[i] >= a[i + 1])
			i--;
		if (i >= 0) {
			int j = a.length - 1;
			while (a[j] <= a[i])
				j--;
			int temp = a[j];
			a[j] = a[i];
			a[i] = temp;
		}
		int start = i + 1;
		int end = a.length - 1;
		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(a));
	}
}
