package a1_arrays;

import java.util.Arrays;

public class C1_RearrangeArrayInAltPosAndNeg {

	/*
	 * https://www.geeksforgeeks.org/rearrange-array-alternating-positive-negative-
	 * items-o1-extra-space/
	 * 
	 * Given an array of positive and negative numbers, arrange them in an alternate
	 * fashion such that every positive number is followed by negative and
	 * vice-versa maintaining the order of appearance. Number of positive and
	 * negative numbers need not be equal. If there are more positive numbers they
	 * appear at the end of the array. If there are more negative numbers, they too
	 * appear in the end of the array.
	 * 
	 * Examples :
	 * 
	 * Input: arr[] = {1, 2, 3, -4, -1, 4} Output: arr[] = {-4, 1, -1, 2, 3, 4}
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 2, 3, -4, -1, 6, -9, -5, 2 };
		// step 1: move negative numbers before the positive figures(partitioning)
		int p = 0;
		int pivot = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < pivot) {
				int tmp = a[p];
				a[p] = a[i];
				a[i] = tmp;
				p++;
			}
		}
		// `p` holds the index of the first positive element
		// step 2: start alternating
		for (int n = 0; p < a.length && n < p; n += 2, p++) {
			int tmp = a[p];
			a[p] = a[n];
			a[n] = tmp;
		}
		System.out.println(Arrays.toString(a));
	}
}
