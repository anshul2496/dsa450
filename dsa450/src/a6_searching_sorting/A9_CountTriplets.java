package a6_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/count-triplets-with-sum-smaller-than-x5549/1
 * https://www.youtube.com/watch?v=fLHOkJHE-NI
 */
public class A9_CountTriplets {
	public static void main(String[] args) {
		int[] a = { -2, 0, 1, 3 };
		int sum = 2;
		Arrays.sort(a);
		int count = 0;
		for (int i = 0; i < a.length - 2; i++) {
			int j = i + 1;
			int k = a.length - 1;
			while (j < k) {
				int sum1 = a[i] + a[j] + a[k];
				if (sum1 < sum) {
					count += (k - j);
					j++;
				}
				else
					k--;
			}
		}
		System.out.println(count);
	}
}
