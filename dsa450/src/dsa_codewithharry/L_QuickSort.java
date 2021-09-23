package dsa_codewithharry;

public class L_QuickSort {

	public static void main(String[] args) {
		int[] a = { 6, 80, 9, 2, 1, 5 };
		quickSort(a, 0, a.length - 1);
		print(a);
	}

	private static void quickSort(int[] a, int low, int high) {
		int partitionIndex;
		if (low < high) {
			partitionIndex = partition(a, low, high);
			quickSort(a, low, partitionIndex - 1);
			quickSort(a, partitionIndex + 1, high);
		}
	}

	private static int partition(int[] a, int low, int high) {
		int i, j, temp, pivot;
		i = low + 1;
		j = high;
		pivot = a[low];
		do {
			while (a[i] <= pivot) {
				i++;
			}
			while (a[j] > pivot) {
				j--;
			}
			if (i < j) {
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		} while (i < j);
		temp = a[low];
		a[low] = a[j];
		a[j] = temp;
		return j;
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
