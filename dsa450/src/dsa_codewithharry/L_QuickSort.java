package dsa_codewithharry;

/*
 * Partitioning an array -  https://www.youtube.com/watch?v=if40LxQ8_Xo
 * Quick Sort - https://www.youtube.com/watch?v=kdO5Q0nmPjU
 */
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
		int i = low;
		int j = low;
		int pivot = a[high];
		while (i <= high) {
			if (a[i] > pivot)
				i++;
			else {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
		return j - 1;
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
