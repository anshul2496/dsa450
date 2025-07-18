package a1_arrays;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 * 
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in
 * ascending order.
 * Example 1:
 * Input: N = 5 arr[]= {0 2 1 2 0} Output: 0 0 1 2 2 Explanation: 0s 1s and 2s
 * are segregated into ascending order.
 */

public class A4_SortArrayWithoutAnyAlgo {

	public static void main(String[] args) {
		//solution1_mybrute(); // O(n2)
		solution2_comparisonSeggregation(); // Time : O(n). Check GFG link also for count approach
		//Partition can also be applied over here, keeping the pivot element as 1.
	}

	private static void solution2_comparisonSeggregation() {
		int[] arr = { 1, 1, 1, 2, 2, 0, 0 };
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int temp;
		while (mid <= high) {
			switch (arr[mid]) {
				case 0: {
					temp = arr[low];
					arr[low] = arr[mid];
					arr[mid] = temp;
					low++;
					mid++;
					break;
				}
				case 1: {
					mid++;
					break;
				}
				case 2: {
					temp = arr[high];
					arr[high] = arr[mid];
					arr[mid] = temp;
					high--;
					break;
				}
			}
		}
		Arrays.stream(arr).forEach(System.out::println);
	}

	private static void solution1_mybrute() {
		int[] arr = { 1, 1, 1, 2, 2, 0, 0 };
		int temp;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		Arrays.stream(arr).forEach(System.out::println);
	}
}
