package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/first-and-last-occurrences-of-x3116/1
 * https://www.youtube.com/watch?v=Y7LiLNdayF0
 */
public class A1_FirstLastOccurences {
	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 5, 5, 5, 7, 123, 125 };
		int x = 5;
		int low = 0;
		int high = a.length - 1;
		int start = -1, end = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				start = mid;
				// continue searching on left
				high = mid - 1;
			} else if (x > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		low = 0;
		high = a.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == x) {
				end = mid;
				// continue searching on right
				low = mid + 1;
			} else if (x > a[mid])
				low = mid + 1;
			else
				high = mid - 1;
		}

		System.out.println(start + " " + end);
	}
}
