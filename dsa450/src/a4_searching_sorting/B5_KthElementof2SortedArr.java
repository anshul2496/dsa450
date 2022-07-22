package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
 * https://www.youtube.com/watch?v=nv7F4PiLUzo
 * *****This is same as median of two sorted arrays.***** -> https://www.youtube.com/watch?v=afwPSXmRsGs&t=1s
 * Input:
	arr1[] = {2, 3, 6, 7, 9}
	arr2[] = {1, 4, 8, 10}
	k = 5
	Output:
	6
	Explanation:
	The final sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10 The 5th element of this array is 6.
 */
public class B5_KthElementof2SortedArr {
	public static void main(String[] args) {
		int[] a = { 1, 10, 10, 25, 40, 54, 79 };
		int[] b = { 15, 24, 27, 32, 33, 39, 48, 68, 82, 88, 90 };
		int k = 15;
		// int kthElement = kthElement(a, b, a.length, b.length, k);
		int kthElement = getKthElement(a, b, k);
		System.out.println(kthElement);
	}

	// Optimum solution - O(log(min(m,n))) and O(1)
	private static int getKthElement(int[] a, int[] b, int k) {
		if (a.length > b.length)
			return getKthElement(b, a, k);
		int n1 = a.length;
		int n2 = b.length;
		// Only low and high are different from median question
		int low = Math.max(0, k - n2);
		int high = Math.min(k, n1);
		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = k - cut1;
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
			int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
			int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];
			if (l1 > r2) {
				high = cut1 - 1;
			} else if (l2 > r1) {
				low = cut1 + 1;
			} else {
				return Math.max(l1, l2);
			}
		}
		return 0;
	}

	// My solution - Inspired from merge 2 sorted arrays without extra space.
	public static int kthElement(int a1[], int a2[], int n, int m, int x) {
		int i = 0;
		int j = 0;
		int k = n - 1;
		while (i <= k && j < m) {
			if (a1[i] < a2[j])
				i++;
			else {
				int temp = a2[j];
				a2[j] = a1[k];
				a1[k] = temp;
				k--;
				j++;
			}
		}
		Arrays.sort(a1);
		Arrays.sort(a2);
		if (x <= a1.length)
			return a1[k - 1];
		else {
			x = x - a1.length;
			return a2[k - 1];
		}
	}
}
