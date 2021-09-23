package dsa_codewithharry;

public class I_BubbleSort {

	public static void main(String[] args) {
		int[] a = { 6, 80, 9, 2, 1, 5 };
		//bubbleSort(a, a.length);
		adaptiveBubbleSort(a, a.length);
		print(a);
	}

	private static void adaptiveBubbleSort(int[] a, int n) {
		int temp;
		boolean isSorted = true;
		for (int i = 0; i < n; i++) { // For no. of passes
			for (int j = 0; j < n - 1 - i; j++) { // For no. of comparisons
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
					isSorted = false;
				}
			}
			if(isSorted) {
				return;
			}
		}
	}

	private static void bubbleSort(int[] a, int n) {
		int temp;
		for (int i = 0; i < n; i++) { // For no. of passes
			for (int j = 0; j < n - 1 - i; j++) { // For no. of comparisons
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}

	private static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
