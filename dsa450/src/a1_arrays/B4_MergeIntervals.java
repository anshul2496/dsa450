package a1_arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
 * https://leetcode.com/problems/merge-intervals/ 
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and
 * return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
 * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6] overlaps,
 * merge them into [1,6].
 */
public class B4_MergeIntervals {
	public static void main(String[] args) {
		solution1(); // Time : O(nlogn) ; Space : O(nm)
	}

	private static void solution1() {
		int[][] a = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : a) {
			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		// return merged.toArray(new int[merged.size()][]);
		merged.stream().forEach(x -> System.out.println(Arrays.toString(x)));
	}
}
