package b2_heaps;

/*
 * https://www.geeksforgeeks.org/problems/convert-min-heap-to-max-heap-1666385109/1
 */
public class B6_MinToMaxHeap {
	public static void main(String[] args) {

	}

	static void convertMinToMaxHeap(int n, int arr[]) {
		int si = (n / 2) - 1;
		for (int i = si; i >= 0; i--) {
			heapify(arr, i, n);
		}
	}

	static void heapify(int[] arr, int i, int n) {
		int largest = i;
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		if (left < n && arr[left] > arr[largest])
			largest = left;
		if (right < n && arr[right] > arr[largest])
			largest = right;
		if (largest != i) {
			int temp = arr[largest];
			arr[largest] = arr[i];
			arr[i] = temp;
			heapify(arr, largest, n);
		}
	}
}
