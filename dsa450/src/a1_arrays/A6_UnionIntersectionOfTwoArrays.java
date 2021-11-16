package a1_arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class A6_UnionIntersectionOfTwoArrays {
	/*
	 * https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1
	 * 
	 * Given two arrays a[] and b[] of size n and n respectively. The task is to
	 * find union between these two arrays.
	 * Union of the two arrays can be defined as the set containing distinct
	 * elements from both the arrays. If there are repetitions, then only one
	 * occurrence of element should be printed in union.
	 * 
	 * Input: 5 3 
	 * 1 2 3 4 5 
	 * 1 2 3
	 * 
	 * Output: 5
	 * Explanation: 1, 2, 3, 4 and 5 are the elements which comes in the union set
	 * of both arrays. So count is 5.
	 */
	public static void main(String[] args) {
		solution1_set(); //O(m+n)
		// Other solutions include using a Map or sort the arrays(using O(nlogn) algo) and then use binary search

	}

	private static void solution1_set() {
		System.out.println("Ente r size of two arrays =");
		Scanner ob = new Scanner(System.in);
		int n1 = ob.nextInt();
		int n2 = ob.nextInt();
		Integer[] a1 = new Integer[n1];
		Integer[] a2 = new Integer[n2];
		System.out.println("Enter 1st array of size " + n1);
		for (int i = 0; i < n1; i++) {
			a1[i] = ob.nextInt();
		}
		System.out.println("Enter 2nd array of size " + n2);
		for (int i = 0; i < n2; i++) {
			a2[i] = ob.nextInt();
		}
		Set<Integer> set = Arrays.stream(a1).collect(Collectors.toSet());
		set.addAll(Arrays.stream(a2).collect(Collectors.toSet()));
		System.out.println("Union set length="+set.size());
		
		// Intersection
		set = Arrays.stream(a1).collect(Collectors.toSet());
		set.retainAll(Arrays.stream(a2).collect(Collectors.toSet()));
		System.out.println("Intersection set length="+set.size());
		
		ob.close();
	}
}
