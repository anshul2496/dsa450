package a1_arrays;

import java.util.ArrayList;
import java.util.List;

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
public class C6_ArraySubsetOfanotherArray {
	public static void main(String[] args) {
		long[] a1 = { 11, 7, 1, 13, 21, 3, 7, 3 };
		long[] a2 = { 11, 3, 7, 1, 7 };
		System.out.println(isSubset(a1, a2, a1.length, a2.length));
	}

	public static String isSubset(long a1[], long a2[], long n, long m) {
		List<Long> list = new ArrayList<>();
		for (long num : a1)
			list.add(num);
		for (long num : a2)
			if (!list.contains(num))
				return "No";
			else
				list.remove(num);
		return "Yes";
	}
}
