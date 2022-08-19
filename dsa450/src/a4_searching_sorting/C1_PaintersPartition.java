package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/the-painters-partition-problem1535/1/
 * This problem is similar to Book Allocation
 */
public class C1_PaintersPartition {
	public static void main(String[] args) {
		int n = 5;
		int k = 3;
		int[] a = { 5, 10, 30, 20, 15 };
		int time = getMinimumOfMaximumTime(a, n, k);
		System.out.println(time);
	}

	private static int getMinimumOfMaximumTime(int[] a, int n, int k) {
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
			int mid = (low + high) / 2;
			if (canBeAllocated(a, n, k, mid)) {
				high = mid - 1;
				ans = mid;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean canBeAllocated(int[] a, int n, int k, int mid) {
		int sum = a[0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			sum += a[i];
			if (sum > mid) {
				count++;
				sum = a[i];
			}
		}
		return count <= k;
	}
}
