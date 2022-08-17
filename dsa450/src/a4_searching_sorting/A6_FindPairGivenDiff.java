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

	private static boolean checkPairPresent(int[] a, int n) {
		Arrays.sort(a);
		int i = 0;
		int j = 1;
		int size = a.length;
		while (i < size && j < size) {
			if (i != j) {
				int diff = a[j] - a[i];
				if (diff == n)
					return true;
				else if (diff > n)
					i++;
				else
					j++;
			} else {
				j++;
			}
		}
		return false;
	}
}
