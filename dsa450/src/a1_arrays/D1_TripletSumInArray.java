package a1_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 	https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1
 * 	Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.
	Example 1:
	Input:
	n = 6, X = 13
	arr[] = [1 4 45 6 10 8]
	Output:
	1
	Explanation:
	The triplet {1, 4, 8} in 
	the array sums up to 13.
 */
public class D1_TripletSumInArray {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		Integer[] a = { 45, 1, 4, 6, 10, 8 };
		int k = 13;
		int flag = 0;
		Set<Integer> set = new HashSet<>(Arrays.asList(a));
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				int sum = a[i] + a[j];
				int rem = k - sum;
				if (rem != a[j] && set.contains(rem)) {
					System.out.println("There exists a triplet.");
					flag = 1;
					break;
				}
			}
			if (flag == 1)
				break;
		}
		if (flag == 0)
			System.out.println("No triplet");
	}
}
