package a6_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
 * youtube.com/watch?v=okP-e2VpI_g
 * Here we have to find the Minimum of Largest
 */
public class B7_BookAllocation {
	public static void main(String[] args) {
		int[] a = { 12, 34, 67, 90 };
		int m = 2;
		int n = 4;
		int ans = getMinOfLargestPages(a, m, n);
		System.out.println(ans);
	}

	private static int getMinOfLargestPages(int[] a, int m, int n) {
		int sum = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			max = Math.max(max, a[i]);
		}
		int low = max;
		int high = sum;
		int ans = 0;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canBeAllocated(a, m, n, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean canBeAllocated(int[] a, int m, int n, int mid) {
		int sum = 0;
		int count = 1;
		for (int i = 0; i < n; i++) {
			sum += a[i];
			if (sum > mid) {
				count++;
				sum = a[i];
			}
		}
		return count <= m;
	}
}
