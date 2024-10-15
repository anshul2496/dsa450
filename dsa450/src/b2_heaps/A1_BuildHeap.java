package b2_heaps;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/building-heap-from-array/
 * https://www.youtube.com/watch?v=ywx-Onrdx4U --> Insertion/Deletion in heap
 * https://www.youtube.com/watch?v=UVW0NfG_YWA --> Build Heap/Heapsort
 */
public class A1_BuildHeap {
	public static void main(String[] args) {
		// Binary Tree Representation
        // of input array
        //            1
        //         /      \
        //       3        5
        //     /   \     / \
        //  4       6  	13 10
        // / \    /  \
        // 9  8  15   17
		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };
		int n = arr.length;
		buildHeap(arr, n);
		System.out.println(Arrays.toString(arr));
	}

	// Function to build a max heap from the array
	private static void buildHeap(int[] arr, int n) {
		// Index of last non-leaf node
		int startIndex = (n / 2) - 1;

		// Perform reverse level order traversal from last non leaf node
		// and heapify each node
		for (int i = startIndex; i >= 0; i--) {
			heapify(arr, n, i);
		}
	}

	// Heapifying a subtree with root at 'i' index
	private static void heapify(int[] arr, int n, int i) {
		int largest = i; // Intialize the coming index as largest
		int l = (2 * i) + 1;
		int r = (2 * i) + 2;
		// Check which is largest from left node and right node
		if (l < n && arr[l] > arr[largest])
			largest = l;
		if (r < n && arr[r] > arr[largest])
			largest = r;
		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			// Recursively heapify the affected subtree
			heapify(arr, n, largest);
		}
	}
}
