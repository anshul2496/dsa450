package a1_arrays;

import java.util.Arrays;

public class A5_MoveAllNegativeToOneSide {

	/*
	 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
	 * 
	 */
	public static void main(String[] args) {
		solution1(); // My approach is good. O(n)
	}

	private static void solution1() {
		int[] a = { -1, 2, -3, 4, 11, -5, 6, -7, 8, -9 };
		int low = 0;
		int high = a.length - 1;
		int temp;
		while (low <= high) {
			if (a[low] < 0) {
				low++;
			} else if (a[high] > 0) {
				high--;
			} else {
				temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				low++;
				high--;

			}
		}
		Arrays.stream(a).forEach(System.out::println);
	}
}
