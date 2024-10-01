package a9_backtracking;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/tug-of-war/
 * https://www.youtube.com/watch?v=Q1fLW_zQr3M
 */
public class A9_TugOfWar {
	static int minDiff = Integer.MAX_VALUE;
	static String ans = "";

	public static void main(String[] args) {
		int[] arr = { 23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4 };
		solve(arr, 0, new ArrayList<>(), new ArrayList<>(), 0, 0);
		System.out.println(minDiff);
		System.out.println(ans);
	}

	private static void solve(int[] arr, int vidx, ArrayList<Integer> set1, ArrayList<Integer> set2, int sumSet1,
			int sumSet2) {
		if (vidx == arr.length) {
			int delta = Math.abs(sumSet2 - sumSet1);
			if (delta < minDiff) {
				minDiff = delta;
				ans = set1 + " " + set2;
			}
			return;
		}
		if (set1.size() < (arr.length + 1) / 2) {
			set1.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, sumSet1 + arr[vidx], sumSet2);
			set1.remove(set1.size() - 1);
		}
		if (set2.size() < (arr.length + 1) / 2) {
			set2.add(arr[vidx]);
			solve(arr, vidx + 1, set1, set2, sumSet1, sumSet2 + arr[vidx]);
			set2.remove(set2.size() - 1);
		}

	}
}
