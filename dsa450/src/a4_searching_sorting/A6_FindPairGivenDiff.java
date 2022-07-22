package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/find-pair-given-difference1559/1
 * https://www.youtube.com/watch?v=XGrXiVi7Ces
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
		int i = 0;
		int j = 1;
		while (i < a.length && j < a.length) {
			if (a[j] - a[i] == diff)
				return true;
			else if (a[j] - a[i] < diff)
				j++;
			else
				i++;
		}
		return false;
	}
}
