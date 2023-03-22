package a1_arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/move-negative-numbers-beginning-positive-end-constant-extra-space/
 */
public class A5_MoveAllNegativeToOneSide {

	public static void main(String[] args) {
		//solution1(); // O(n) - Not in place
		solution2(); // O(n) - Partition approach of quick sort. O(n) Time and O(1) Space
	}

	private static void solution2() {
		int[] a = { -1, 2, -3, 4, 11, -5, 6, -7, 8, -9 };
		partition(a, 0, a.length - 1, 0);
		System.out.println(Arrays.toString(a));
	}

	private static void partition(int[] a, int low, int high, int pivot) {
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
			} else if (a[low] > 0 && a[high] < 0) {
				temp = a[low];
				a[low] = a[high];
				a[high] = temp;
				low++;
				high--;

			}
		}
		System.out.println(Arrays.toString(a));
	}
}
