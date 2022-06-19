package a6_searching_sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
 */
public class A7_FindAllFourSumNumbers {
	public static void main(String[] args) {
		int[] a = { 10, 2, 3, 4, 5, 7, 8 };
		int k = 23;
		ArrayList<ArrayList<Integer>> list = getFourSum(a, k);
		System.out.println(list);
	}

	private static ArrayList<ArrayList<Integer>> getFourSum(int[] a, int sum) {
		Set<Integer> set = new HashSet<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				for (int k = j + 1; k < a.length; k++) {
					int rem = sum - (a[i] + a[j] + a[k]);
					if (set.contains(rem)) {
						if (rem != a[i] && rem != a[j] && rem != a[k]) {
							ArrayList<Integer> temp = new ArrayList<>();
							temp.add(a[i]);
							temp.add(a[j]);
							temp.add(a[k]);
							temp.add(rem);
							Collections.sort(temp);
							if (!list.contains(temp)) {
								list.add(temp);
							}
						}
					}
				}
			}
		}
		return list;
	}
}
