package b2_heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description/
 * https://www.youtube.com/watch?v=aH-2Sig2H2Q
 */
public class B1_SmallestRangeinKLists {
	public static void main(String[] args) {
		Integer[] a1 = { 4, 10, 15, 24, 26 };
		Integer[] a2 = { 0, 9, 12, 20 };
		Integer[] a3 = { 5, 18, 22, 30 };
		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(a1));
		list.add(Arrays.asList(a2));
		list.add(Arrays.asList(a3));
		int[] ans = smallestRange(list);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] smallestRange(List<List<Integer>> nums) {
		int[] range = { -100000, 100000 };
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return a[0] - b[0];
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> list = nums.get(i);
			int minOfList = list.get(0);
			int[] temp = { minOfList, 0, i };
			// 0th index -> min element of the list
			// 1st index -> index of the element
			// 2nd index -> index of the list
			pq.add(temp);
			max = Math.max(max, minOfList);
		}
		while (true) {
			int[] min = pq.poll();
			if (max - min[0] < range[1] - range[0]) {
				range[0] = min[0];
				range[1] = max;
			}
			min[1]++;
			if (min[1] == nums.get(min[2]).size())
				break;
			else {
				min[0] = nums.get(min[2]).get(min[1]);
				max = Math.max(max, min[0]);
				pq.add(min);
			}
		}
		return range;
	}
}
