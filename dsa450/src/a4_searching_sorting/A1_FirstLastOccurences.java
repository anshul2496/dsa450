package a4_searching_sorting;

import java.util.ArrayList;

/*
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * https://www.youtube.com/watch?v=Y7LiLNdayF0
 */
public class A1_FirstLastOccurences {
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
		int x = 5;
		int low = 0;
		int high = a.length - 1;
		int start = -1, end = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				start = mid;
				// continue searching on left
				high = mid - 1;
			} else if (x > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		low = 0;
		high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				end = mid;
				// continue searching on right
				low = mid + 1;
			} else if (x > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		System.out.println(start + " " + end);
	}

	// My code
	ArrayList<Integer> find(int arr[], int x) {
		ArrayList<Integer> list = new ArrayList<>();
		int si = binarySearch(arr, x, true);
		int ei = binarySearch(arr, x, false);
		list.add(si);
		list.add(ei);
		return list;
	}

	int binarySearch(int[] arr, int x, boolean start) {
		int index = -1;
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == x) {
				if (start && mid != 0 && arr[mid - 1] == x)
					high = mid - 1;
				else if (!start && mid != arr.length - 1 && arr[mid + 1] == x)
					low = mid + 1;
				else {
					index = mid;
					break;
				}
			} else if (arr[mid] > x) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return index;
	}
}
