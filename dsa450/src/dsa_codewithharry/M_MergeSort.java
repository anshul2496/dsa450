package dsa_codewithharry;

public class M_MergeSort {

	public static void main(String[] args) {
		int[] a = { 6, 80, 9, 2, 1, 5 };
		mergeSort(a, 0, a.length - 1);
		print(a);
	}

	private static void mergeSort(int[] a, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(a, low, mid);
			mergeSort(a, mid + 1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {
		int i, j, k;
		int[] b = new int[high + 1];
		i = low;
		j = mid + 1;
		k = low;
		while (i <= mid && j <= high) {
			if (a[i] < a[j]) {
				b[k] = a[i];
				i++;
				k++;
			} else {
				b[k] = a[j];
				j++;
				k++;
			}
		}
		while (i <= mid) {
			b[k] = a[i];
			i++;
			k++;
		}
		while (j <= high) {
			b[k] = a[j];
			j++;
			k++;
		}
		for (i = low; i <= high; i++) {
			a[i] = b[i];
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
