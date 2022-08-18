package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://www.spoj.com/problems/AGGRCOW/
 * https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559
 * Problem Video - https://www.youtube.com/watch?v=ii0riJELUhA
 * Solution video - https://www.youtube.com/watch?v=XgnEFbraeiY
 * Here we have to find the Largest of Minimum(Minimum distance between cows should be as large as possible)
 */
public class B6_AggressiveCows {
	public static void main(String[] args) {
		int stalls = 5; // d
		int cows = 3; // n
		int[] positions = { 1, 2, 8, 4, 9 };
		int dist = getLargestMinimumDistance(positions, stalls, cows); // O(nlog(d))
		System.out.println(dist);
	}

	private static int getLargestMinimumDistance(int[] a, int n, int c) {
		Arrays.sort(a);
		int low = 0;
		int high = a[n - 1] - a[0];
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
