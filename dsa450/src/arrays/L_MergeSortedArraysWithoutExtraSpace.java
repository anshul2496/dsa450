package arrays;

import java.util.Arrays;

public class L_MergeSortedArraysWithoutExtraSpace {

	/*
	 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays5135/1
	 * Given two sorted arrays arr1[] of size N and arr2[] of size M. Each array is
	 * sorted in non-decreasing order. Merge the two arrays into one sorted array in
	 * non-decreasing order without using any extra space.
	 * Example 1:
	 * 
	 * Input: N = 4, M = 5 arr1[] = {1, 3, 5, 7} arr2[] = {0, 2, 6, 8, 9} Output: 0
	 * 1 2 3 5 6 7 8 9 Explanation: Since you can't use any extra space, modify the
	 * given arrays to form arr1[] = {0, 1, 2, 3} arr2[] = {5, 6, 7, 8, 9}
	 */
	public static void main(String[] args) {
		solution1(); // O(n*m)
	}

	private static void solution1() {
		int[] a1 = { 1, 3, 5, 7 };
		int[] a2 = { 0, 2, 6, 8, 9 };
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] > a2[0]) {
				int temp = a1[i];
				a1[i] = a2[0];
				a2[0] = temp;

				/*
				 * after swaping we have to sort the array2 again so that it can be again swap
				 * with arr1
				 * we will store the firstElement of array2 and left shift all the element and
				 * store the firstElement in arr2[k-1]
				 */
				int firstElement = a2[0];
				int k;
				for (k = 1; k < a2.length && a2[k]<firstElement; k++) {
					a2[k-1]=a2[k];
				}
				a2[k-1]=firstElement;
			}
		}
		Arrays.stream(a1).forEach(a -> System.out.print(a+" "));
		Arrays.stream(a2).forEach(a -> System.out.print(a+" "));
	}

}
