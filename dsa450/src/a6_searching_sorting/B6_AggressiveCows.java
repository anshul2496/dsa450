package a6_searching_sorting;

import java.util.Arrays;

/*
 * https://www.spoj.com/problems/AGGRCOW/
 * Problem Video - https://www.youtube.com/watch?v=ii0riJELUhA
 * Solution video - https://www.youtube.com/watch?v=XgnEFbraeiY
 */
public class B6_AggressiveCows {
	public static void main(String[] args) {
		int stalls = 5;
		int cows = 3;
		int[] positions = { 1, 2, 8, 4, 9 };
		int dist = getLargestMinimumDistance(positions, stalls, cows);
		System.out.println(dist);
	}

	private static int getLargestMinimumDistance(int[] a, int n, int c) {
		Arrays.sort(a);
		int low = 0;
		int high = n - 1;
		int ans = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (check(a, n, c, mid)) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return ans;
	}

	private static boolean check(int[] a, int n, int c, int mid) {
		int count = 1;
		int lastPosition = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] - lastPosition >= mid) {
				lastPosition = a[i];
				count++;
			}
			if (count == c)
				return true;
		}
		return false;
	}
}
