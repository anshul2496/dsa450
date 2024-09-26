package a1_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/*
 * https://practice.geeksforgeeks.org/problems/common-elements1132/1
 * https://www.youtube.com/watch?v=kvmVCSHSlU4 -- Outdated, New test cases failing in gfg
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data
 * Structure? Example 1: Input: n1 = 6; A = {1, 5, 10, 20, 40, 80} n2 = 5; B =
 * {6, 7, 20, 80, 100} n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120} Output: 20 80
 * Explanation: 20 and 80 are the only common elements in A, B and C.
 */
public class B8_CommonElementIn3Arrays {
	public static void main(String[] args) {
		// solution1(); // Using set data structure
		// solution2(); // Without using any data structure - Outdated, New test cases failing in gfg
		List<Integer> ans = commonElements(Arrays.asList(10, 16, 21, 43, 55, 57, 73, 90, 95),
				Arrays.asList(22, 54, 56, 62, 77, 95), Arrays.asList(5, 9, 15, 17, 40, 42, 55, 71, 95));
		System.out.println(ans);
	}

	public static List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
		List<Integer> result = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		while (i < arr1.size() && j < arr2.size() && k < arr3.size()) {
			int num1 = arr1.get(i);
			int num2 = arr2.get(j);
			int num3 = arr3.get(k);

			if (num1 == num2 && num2 == num3) {
				if (result.isEmpty() || result.get(result.size() - 1) != num1) { // result.contains is giving TLE
					result.add(num1);
				}
				i++;
				j++;
				k++;
			} else if (num1 < num2) {
				i++;
			} else if (num2 < num3) {
				j++;
			} else {
				k++;
			}
		}
		return result;
	}

	private static void solution2() {
		int[] a = { 10, 16, 21, 43, 55, 57, 73, 90, 95 };
		int[] b = { 22, 54, 56, 62, 77, 95 };
		int[] c = { 5, 9, 15, 17, 40, 42, 55, 71, 95 };
		int i = 0, j = 0, k = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (i < a.length && j < b.length && k < c.length) {
			if (a[i] < b[j])
				i++;
			else if (a[i] > b[j])
				j++;
			else {
				while (k < c.length && c[k] < b[j]) {
					k++;
				}
				if (k < c.length && c[k] == b[j]) {
					if (!list.contains(c[k])) {
						list.add(c[k]);
					}
				}
				i++;
				j++;
			}
		}
		System.out.println(list);
	}

	private static void solution1() {
		Integer[] a = { 1, 5, 10, 20, 40, 80 };
		Integer[] b = { 6, 7, 20, 80, 100 };
		Integer[] c = { 3, 4, 15, 20, 30, 70, 80, 120 };
		Set<Integer> set = new LinkedHashSet<>(Arrays.asList(a));
		set.retainAll(Arrays.asList(b));
		set.retainAll(Arrays.asList(c));
		System.out.println(set);
	}
}
