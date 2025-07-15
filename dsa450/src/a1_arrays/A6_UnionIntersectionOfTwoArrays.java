package a1_arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
 * Given two arrays a[] and b[] of size n and n respectively. The task is to find union between these two arrays.
 * Union of the two arrays can be defined as the set containing distinct
 * elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in union.
 * Input: 5 3 
 * 1 2 3 4 5 
 * 1 2 3
 * Output: 5
 * Explanation: 1, 2, 3, 4 and 5 are the elements which comes in the union set of both arrays. So count is 5.
 */
public class A6_UnionIntersectionOfTwoArrays {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int n = a.length;
		int[] b = { 1, 2, 3 };
		int m = b.length;
		System.out.println(doUnion(a, n, b, m)); // O(m+n)
	}

	public static int doUnion(int a[], int n, int b[], int m) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n; i++)
			set.add(a[i]);
		for (int i = 0; i < m; i++)
			set.add(b[i]);
		return set.size();
		
		//Set<Integer> set = new HashSet<>(Arrays.asList(a)); // Doesn't work
		//because you're trying to use Arrays.asList(int[]), 
		// but Java treats primitive arrays (int[]) as a single object, not a list of elements.
		/* Correct using streams -
		 * Set<Integer> set = Arrays.stream(a)          // IntStream
                         .boxed()            // Stream<Integer>
                         .collect(Collectors.toSet());
		 */
	}
	// For intersection use retainAll()
}
