package b2_heaps;

/*
 * https://www.geeksforgeeks.org/problems/merge-two-binary-max-heap0144/1
 * https://www.youtube.com/watch?v=GvduQ_In6qA
 */
public class A6_Mege2BinaryMaxHeaps {
	public static void main(String[] args) {

	}
	
	public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
		int[] ans = new int[n + m];
		for (int i = 0; i < n; i++)
			ans[i] = a[i];
		for (int i = 0; i < m; i++)
			ans[n + i] = b[i];
		int k = n + m;
		int si = (k / 2) - 1;
		for (int i = si; i >= 0; i--)
			heapify(ans, k, i);
		return ans;
	}

	public void heapify(int[] arr, int n, int i) {
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
