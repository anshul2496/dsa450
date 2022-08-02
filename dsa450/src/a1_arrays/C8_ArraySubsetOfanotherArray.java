package a1_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 	https://practice.geeksforgeeks.org/problems/array-subset-of-another-array2317/1
 * 	Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. Task is to check whether a2[] is a subset of a1[] or not. 
 * 	Both the arrays can be sorted or unsorted. It may be assumed that elements in both array are distinct.
	Input:
	a1[] = {11, 1, 13, 21, 3, 7}
	a2[] = {11, 3, 7, 1}
	Output:
	Yes
	Explanation:
	a2[] is a subset of a1[]
 */
public class C8_ArraySubsetOfanotherArray {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		Integer[] a1 = { 11, 1, 13, 21, 3, 7 };
		Integer[] a2 = { 11, 3, 7, 1 };
		Set<Integer> set = new HashSet<>(Arrays.asList(a1));
		int flag = 0;
		for (Integer num : a2) {
			if (!set.contains(num)) {
				System.out.println("Not subset");
				flag = 1;
				break;
			}
		}
		if (flag == 0)
			System.out.println("It is subset");
	}
}
