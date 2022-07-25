package dsa_codewithharry;

public class S_BinarySearch {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(binarySearch(a, 2));
	}

	private static boolean binarySearch(int[] a, int key) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (key == a[mid])
				return true;
			else if (key < a[mid])
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
}
