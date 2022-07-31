package a1_arrays;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
 * https://www.youtube.com/watch?v=POTD3tZ2S4s 
 * Given two sorted arrays arr1[] of
 * size N and arr2[] of size M. Each array is sorted in non-decreasing order.
 * Merge the two arrays into one sorted array in non-decreasing order without
 * using any extra space. Example 1:
 * Input: N = 4, M = 5 arr1[] = {1, 3, 5, 7} arr2[] = {0, 2, 6, 8, 9} Output: 0
 * 1 2 3 5 6 7 8 9 Explanation: Since you can't use any extra space, modify the
 * given arrays to form arr1[] = {0, 1, 2, 3} arr2[] = {5, 6, 7, 8, 9}
 */
public class B3_MergeSortedArraysWithoutExtraSpace {
	public static void main(String[] args) {
		//solution1(); // O(n*m)
		solution2(); // O(n+m)log(n+m)
	}

	private static void solution2() {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 0, 2, 6, 8, 9 };
		int n = arr1.length;
		int m = arr2.length;
		int i = 0, j = 0, k = n - 1;
		while (i <= k && j < m) {
			if (arr1[i] < arr2[j]) {
				i++;
			} else {
				int temp = arr1[k];
				arr1[k] = arr2[j];
				arr2[j] = temp;
				k--;
				j++;
			}
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		Arrays.stream(arr1).forEach(a -> System.out.print(a + " "));
		Arrays.stream(arr2).forEach(a -> System.out.print(a + " "));
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
				 * with arr1 we will store the firstElement of array2 and left shift all the
				 * element and store the firstElement in arr2[k-1]
				 */
				int firstElement = a2[0];
				int k;
				for (k = 1; k < a2.length && a2[k] < firstElement; k++) {
					a2[k - 1] = a2[k];
				}
				a2[k - 1] = firstElement;
			}
		}
		Arrays.stream(a1).forEach(a -> System.out.print(a + " "));
		Arrays.stream(a2).forEach(a -> System.out.print(a + " "));
	}

}
