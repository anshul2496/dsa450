package a5_interviews;

/*
 * https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
 * Given an array of integers. Find a peak element in it. An array element is a peak if it is NOT smaller than its neighbours. For corner elements, we need to consider only one neighbour. 
	Example:
	Input: array[]= {5, 10, 20, 15}
	Output: 20
	The element 20 has neighbours 10 and 15,
	both of them are less than 20.
 */
public class A9_FindThePeakInArray {
	public static void main(String[] args) {
		int arr[] = { 1, 3, 20, 4, 1, 0 };
		int n = arr.length;
		System.out.println("Index of a peak point is " + findPeak(arr, 0, n - 1, n));
	}

	private static int findPeak(int[] a, int low, int high, int n) {
		int mid = low + (high - low) / 2;
		if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == n - 1 || a[mid] >= a[mid + 1])) {
			return mid;
		} else if (mid > 0 && a[mid - 1] > a[mid]) {
			return findPeak(a, low, mid - 1, n);
		} else {
			return findPeak(a, mid + 1, high, n);
		}
	}
}
