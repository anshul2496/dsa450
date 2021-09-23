package dsa_codewithharry;

public class K_SelectionSort {

	public static void main(String[] args) {
		int[] a = { 6, 80, 9, 2, 1, 5 };
		selectionSort(a, a.length);
		print(a);
	}

	private static void selectionSort(int[] a, int n) {
		int indexofMin, temp;
		for (int i = 0; i < n - 1; i++) {
			indexofMin = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[indexofMin]) {
					indexofMin = j;
				}
			}
			temp = a[i];
			a[i] = a[indexofMin];
			a[indexofMin] = temp;
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
