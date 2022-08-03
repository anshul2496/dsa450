package a1_arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-items-o1-extra-space/
 * Given an array of positive and negative numbers, arrange them in an alternate
 * fashion such that every positive number is followed by negative and
 * vice-versa maintaining the order of appearance. Number of positive and
 * negative numbers need not be equal. If there are more positive numbers they
 * appear at the end of the array. If there are more negative numbers, they too
 * appear in the end of the array.
 * Input: arr[] = {1, 2, 3, -4, -1, 4} Output: arr[] = {-4, 1, -1, 2, 3, 4}
 */
public class B91_RearrangeArrayInAltPosAndNeg {
	public static void main(String[] args) {
		int[] a = { 2, 3, -4, -1, 6, -9, -5, 2, 8, 88 };
		int pi = partition(a, 0, a.length - 1);
		for (int i = 0, j = pi + 1; i < pi + 1 && j < a.length; i += 2, j++) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		System.out.println(Arrays.toString(a));
	}

	private static int partition(int[] a, int low, int high) {
		int pivot = 0;
		int i = low;
		int j = low;
		while (i <= high) {
			if (a[i] > pivot)
				i++;
			else {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
		return j - 1;
	}
}
