package a6_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 */
public class A6_FindPairGivenDiff {
	public static void main(String[] args) {
		int[] a = { 5, 20, 3, 2, 5, 80 };
		int diff = 78;
		boolean isPair = checkPairPresent(a, diff);
		// Other approach is using a set, but there the space would have been O(n)
		System.out.println(isPair);
	}

	private static boolean checkPairPresent(int[] a, int diff) {
		Arrays.sort(a);
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			if (a[high] - a[low] == diff)
				return true;
			else if (a[high] - a[low] > diff)
				high--;
			else
				low++;
		}
		return false;
	}
}
