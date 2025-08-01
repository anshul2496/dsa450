package a1_arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://practice.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
 * Given an array, rotate the array by one position in clock-wise direction.
 * Example 1:
 * Input: N = 5 
 * A[] = {1, 2, 3, 4, 5} 
 * Output: 5 1 2 3 4
 */
public class A7_CyclicallyRotateAnArray {
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
		// In Java, although Streams are not naturally suited for in-place array modifications 
		// or rotations, we can still solve this using Stream-based logic by re-creating a new array.
		// int[] rotated = IntStream.concat(IntStream.of(lastNum), Arrays.stream(A, 0, N - 1)).toArray();
	}
}
