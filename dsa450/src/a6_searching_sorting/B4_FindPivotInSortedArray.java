package a6_searching_sorting;

/*
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * https://www.youtube.com/watch?v=vF7gk4iaklA
 * **** This question is same as find minimum in rotated sorted array
 */
public class B4_FindPivotInSortedArray {
	public static void main(String[] args) {
		int[] a = { 30, 40, 50, 10, 20 }; // Expected o/p = 10
		int low = 0;
		int high = a.length - 1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (a[mid] < a[high]) // This is increasing curve. Pivot will lie on the other side.
				high = mid;
			else
				low = mid + 1;
		}
		System.out.println(a[low]);
	}
}
