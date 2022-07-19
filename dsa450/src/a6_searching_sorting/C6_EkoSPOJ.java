package a6_searching_sorting;

/*
 * https://www.spoj.com/problems/EKO/
 * https://www.youtube.com/watch?v=tkoucfh10SI - Did without watching the video
 */
public class C6_EkoSPOJ {
	public static void main(String[] args) {
		int[] treeHeight = { 20, 15, 10, 17 };
		int m = 7;
		int bladeLen = getMaximumBladeLen(treeHeight, m);
		System.out.println(bladeLen);
	}

	private static int getMaximumBladeLen(int[] a, int m) {
		int low = 0;
		int high = 0;
		int ans = 0;
		for (int i = 0; i < a.length; i++) {
			high = Math.max(high, a[i]);
		}
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canCollectMWood(a, m, mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private static boolean canCollectMWood(int[] a, int m, int mid) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > mid)
				count += (a[i] - mid);
		}
		return count >= m;
	}
}
