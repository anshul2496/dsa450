package a1_arrays;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/reverse-string/
 * Given an array (or string), the task is to reverse the array/string. Examples
 * Input : arr[] = {1, 2, 3} Output : arr[] = {3, 2, 1}
 */
public class A1_ReverseAnArray {

	public static void main(String[] args) {
		solution2_pointers(); // Time Complexity : O(n) ; Space Complexity : O(1)
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
}
