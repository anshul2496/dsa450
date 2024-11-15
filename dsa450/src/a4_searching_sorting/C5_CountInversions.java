package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * https://www.youtube.com/watch?v=uojx--MK_n0
 * Same as C3_Arrays
 */
public class C5_CountInversions {
	public static void main(String[] args) {
		int[] a = { 2, 4, 1, 3, 5 };
		System.out.println(mergeSort(a, 0, a.length - 1));
	}

	static int mergeSort(int[] arr, int low, int high) {
		int count = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			count += mergeSort(arr, low, mid);
			count += mergeSort(arr, mid + 1, high);
			count += merge(arr, low, mid, high);
		}
		return count;
	}

	static int merge(int[] a, int low, int mid, int high) {
		int count = 0;
		int[] b = new int[high + 1];
		int i = low;
		int j = mid + 1;
		int k = low;
		while (i <= mid && j <= high) {
			if (a[i] <= a[j]) {
				b[k++] = a[i++];
			} else {
				count += mid - i + 1;
				b[k++] = a[j++];
			}
		}
		while (i <= mid)
			b[k++] = a[i++];
		while (j <= high)
			b[k++] = a[j++];
		for (i = low; i <= high; i++)
			a[i] = b[i];
		return count;
	}
}