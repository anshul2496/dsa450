package arrays;

import java.util.Arrays;

public class B6_NextPermutation {
	/*
	 * https://leetcode.com/problems/next-permutation/ Implement next permutation,
	 * which rearranges numbers into the lexicographically next greater permutation
	 * of numbers. If such an arrangement is not possible, it must rearrange it as
	 * the lowest possible order (i.e., sorted in ascending order). The replacement
	 * must be in place and use only constant extra memory. Example 1: Input: nums =
	 * [1,2,3] Output: [1,3,2] Example 2: Input: nums = [3,2,1] Output: [1,2,3]
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 1, 5, 8, 4, 7, 6, 5, 3, 1 };
		int i = a.length - 2;
		while (i >= 0 && a[i] >= a[i + 1]) {
			i--;
		}
		if (i >= 0) {
			int j = a.length - 1;
			while (a[j] <= a[i]) {
				j--;
			}
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
		reverse(a, i + 1);
		System.out.println(Arrays.toString(a));
	}

	private static void reverse(int[] a, int start) {
		int i = start;
		int j = a.length - 1;
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
}
