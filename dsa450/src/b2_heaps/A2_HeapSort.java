package b2_heaps;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/heap-sort/
 * https://www.youtube.com/watch?v=UVW0NfG_YWA
 */
public class A2_HeapSort {
	public static void main(String[] args) {
		int arr[] = { 9, 4, 3, 8, 10, 2, 5 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void heapSort(int[] arr) {
		int n = arr.length;
		int si = (n / 2) - 1;
		// Build heap
		for (int i = si; i >= 0; i--) {
			heapify(arr, n, i);
		}
		// One by one extract element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			// Call heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = (2 * i) + 1;
		int right = (2 * i) + 2;
		if (left < n && arr[left] > arr[largest])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;
		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, n, largest);
		}
	}
}
