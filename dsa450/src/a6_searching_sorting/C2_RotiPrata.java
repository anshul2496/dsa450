package a6_searching_sorting;

/*
 * https://www.spoj.com/problems/PRATA/
 * https://www.youtube.com/watch?v=-Nx1h54KzUQ
 */
public class C2_RotiPrata {
	public static void main(String[] args) {
		int p = 10;
		int[] a = { 1, 2, 3, 4 };
		int n = 4;
		int ans = getMinimumMinutes(p, a, n);
		System.out.println(ans);
	}

	private static int getMinimumMinutes(int p, int[] a, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, a[i]);
		}
		int low = max;
		int high = (int) 1e8;
		int ans = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (canAllocate(p, a, n, mid)) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	private static boolean canAllocate(int p, int[] a, int n, int mid) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			int time = a[i];
			int j = 2;
			while (time <= mid) {
				time += (a[i] * j);
				j++;
				count++;
			}
		}
		return count >= p;
	}
}
