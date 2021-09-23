package dsa_codewithharry;

public class J_InsertionSort {

	public static void main(String[] args) {
		int[] a = { 6, 80, 9, 2, 1, 5 };
		insertionSort(a, a.length);
		print(a);
	}

	private static void insertionSort(int[] a, int n) {
		int key, j;
		for (int i = 1; i < n; i++) { // Loop for no. of passes
			key = a[i];
			j = i - 1;
			while (j >= 0 && a[j] > key) { // Loop for each pass
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = key;
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
