package arrays;

import java.util.Arrays;

public class A1_ReverseAnArray {

	/*
	 * Given an array (or string), the task is to reverse the array/string. Examples
	 * 
	 * Input : arr[] = {1, 2, 3} Output : arr[] = {3, 2, 1}
	 * 
	 * <a href =
	 * "https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/"
	 * >link</a>
	 */
	public static void main(String[] args) {
		// solution1_iterative();
		solution2_pointers(); // Final. Time Complexity : O(n)
	}

	private static void solution2_pointers() {
		String[] arr = { "1", "2", "3" };
		int i = 0;
		int j = arr.length - 1;
		String temp;
		while (i < j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void solution1_iterative() {
		String[] arr = { "1", "2", "3" };
		String[] arr2 = new String[arr.length];
		int j = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			arr2[j++] = arr[i];
		}
		Arrays.stream(arr).forEach(System.out::println);
	}

}
