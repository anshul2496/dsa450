package a1_arrays;

import java.util.Arrays;

/*
 * https://www.pepcoding.com/resources/online-java-foundation/time-and-space-complexity/target-sum-pair-1-official/ojquestion
 * https://www.youtube.com/watch?v=4t9jv9AkVdE
 */
public class B72_TargetSumPairElementsUnique {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 18 };
		int sum = 6;
		targetSumPair(arr, sum); // O(nlogn) and O(1)
		// Can also be done by using frequency map technique using hash map but that will take O(n) space
	}

	public static void targetSumPair(int[] a, int k) {
		Arrays.sort(a);
		int i = 0, j = a.length - 1;
		while (i < j) {
			int sum = a[i] + a[j];
			if (sum < k)
				i++;
			else if (sum > k)
				j--;
			else {
				System.out.println(a[i] + ", " + a[j]);
				i++;
				j--;
			}
		}
	}
}
