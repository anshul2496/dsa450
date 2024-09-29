package a1_arrays;

/*
 * https://www.geeksforgeeks.org/problems/inversion-of-array-1587115620/1
 * https://www.youtube.com/watch?v=uojx--MK_n0
 */
public class C3_CountInversions {
	public static void main(String[] args) {
		long[] a = { 2, 4, 1, 3, 5 };
		long count = inversionCount(a);
		System.out.println(count);
	}

	static long inversionCount(long arr[]) {
		long[] temp = new long[arr.length];
		return mergeSort(arr, 0, arr.length - 1, temp);
	}

	static long mergeSort(long[] arr, int low, int high, long[] temp) {
		long count = 0;
		if (low < high) {
			int mid = (low + high) / 2;
			count += mergeSort(arr, low, mid, temp);
			count += mergeSort(arr, mid + 1, high, temp);
			count += merge(arr, low, mid, high, temp);
		}
		return count;
	}

	static long merge(long[] arr, int low, int mid, int high, long[] b) {
		long count = 0;
		int i, j, k;
		// long[] b=new long[high+1];
		i = low;
		j = mid + 1;
		k = low;
		while (i <= mid && j <= high) {
			if (arr[i] <= arr[j]) {
				b[k++] = arr[i++];
			} else {
				count += mid - i + 1;
				b[k++] = arr[j++];
			}
		}
		while (i <= mid) {
			b[k++] = arr[i++];
		}
		while (j <= high) {
			b[k++] = arr[j++];
		}
		for (i = low; i <= high; i++)
			arr[i] = b[i];
		return count;
	}
}
