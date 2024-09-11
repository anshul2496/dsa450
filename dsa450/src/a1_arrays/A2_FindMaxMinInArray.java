package a1_arrays;

import java.util.Arrays;

/*
 * Maximum and minimum of an array using minimum number of comparisons
 * https://practice.geeksforgeeks.org/problems/max-min/1
 */
public class A2_FindMaxMinInArray {

	static class Pair {
		int max;
		int min;
	}

	public static void main(String[] args) {
		// solution1_sort();
		// solution2_linearSearch(); // O(n) -> This is acceptable

		/*
		 * METHOD 3 (Tournament Method) Divide the array into two parts and compare the
		 * maximums and minimums of the two parts to get the maximum and the minimum of
		 * the whole array. Time Complexity is still O(n)
		 */
		solution3_tournamentMethod(); // Time: O(log n)
	}

	private static void solution3_tournamentMethod() {
		int[] a = { 5, 6, 4, 1, 3, 2 };
		Pair minmax = getMinMax(a, 0, a.length - 1);
		System.out.println("Min = " + minmax.min);
		System.out.println("Max = " + minmax.max);

	}

	private static Pair getMinMax(int[] a, int low, int high) {
		Pair minmax = new Pair();
		Pair ml;
		Pair mr;

		if (low == high) {
			minmax.max = a[low];
			minmax.min = a[low];
			return minmax;
		}
		if (high == low + 1) {
			if (a[low] < a[high]) {
				minmax.max = a[high];
				minmax.min = a[low];
			} else {
				minmax.max = a[low];
				minmax.min = a[high];
			}
			return minmax;
		}
		int mid = (high + low) / 2;
		ml = getMinMax(a, low, mid);
		mr = getMinMax(a, mid + 1, high);
		if (ml.min < mr.min) {
			minmax.min = ml.min;
		} else {
			minmax.min = mr.min;
		}
		if (ml.max > mr.max) {
			minmax.max = ml.max;
		} else {
			minmax.max = mr.max;
		}
		return minmax;
	}

	private static void solution2_linearSearch() {
		int[] a = { 5, 6, 4, 1, 3, 2 };
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			min = Math.min(min, a[i]);
			max = Math.max(max, a[i]);
		}
		System.out.println("Min = " + min);
		System.out.println("Max = " + max);
	}

	private static void solution1_sort() {
		int[] a = { 5, 6, 4, 1, 3, 2 };
		Arrays.sort(a);
	}

}
