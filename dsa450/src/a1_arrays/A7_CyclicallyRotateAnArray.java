package a1_arrays;

import java.util.Arrays;

public class A7_CyclicallyRotateAnArray {

	/*
	 * https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
	 * Given an array, rotate the array by one position in clock-wise direction.
	 * Example 1:
	 * Input: N = 5 
	 * A[] = {1, 2, 3, 4, 5} 
	 * Output: 5 1 2 3 4
	 */
	public static void main(String[] args) {
		solution1(); //O(n)
	}

	private static void solution1() {
		int[] a = { 1, 2, 3, 4, 5 };
		int lastNum = a[a.length - 1];
		for (int i = a.length - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = lastNum;
		Arrays.stream(a).forEach(System.out::println);
	}
}
