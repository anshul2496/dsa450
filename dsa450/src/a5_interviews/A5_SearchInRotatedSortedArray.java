package a5_interviews;

/*
 * 	https://practice.geeksforgeeks.org/problems/search-in-a-rotated-array4618/1/
 * 	https://www.youtube.com/watch?v=1uu3g_uu8O0&t=656s
 * 	Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    key = 3
	Output : Found at index 8
 */
public class A5_SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] a = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int target = 3;
		int index = -1;
		int lo = 0;
		int hi = a.length - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (a[mid] == target) {
				index = mid;
				break;
			} else if (a[lo] <= a[mid]) {
				// lo to mid is sorted
				if (target >= a[lo] && target < a[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else if (a[mid] <= a[hi]) {
				// mid to hi is sorted
				if (target > a[mid] && target <= a[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		System.out.println(index);
	}
}
