package a4_searching_sorting;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * https://www.youtube.com/watch?v=1uu3g_uu8O0
 */
public class A2_SearchInRotatedSorted {
	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 7, 0, 1, 2 };
		int target = 6;
		int low = 0;
		int high = a.length - 1;
		int index = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == target) {
				index = mid;
				break;
			} else if (a[low] <= a[mid]) {
				if (target >= a[low] && target < a[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else if (a[mid] <= a[high]) {
				if (target > a[mid] && target <= a[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		System.out.println(index);
	}
}
