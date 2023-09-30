package a8_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * https://www.youtube.com/watch?v=II6ziNnub1Q
 */
public class A1_ActiviySelection {
	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };
		int ans = getMaxMeetings(start, end);
		System.out.println(ans);
	}

	private static int getMaxMeetings(int[] start, int[] end) {
		ArrayList<A1Pair> list = new ArrayList<>();
		for (int i = 0; i < start.length; i++) {
			list.add(new A1Pair(start[i], end[i], i));
		}
		Collections.sort(list, new Comparator<A1Pair>() {
			public int compare(A1Pair p1, A1Pair p2) {
				if (p1.end < p2.end)
					return -1;
				else if (p1.end > p2.end)
					return 1;
				else {
					if (p1.idx < p2.idx)
						return -1;
					else
						return 1;
				}
			}
		});
		int limit = list.get(0).end;
		int ans = 1; // Counting the 1st one
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).start > limit) {
				ans++;
				limit = list.get(i).end;
			}
		}
		return ans;
	}
}

class A1Pair {
	int start;
	int end;
	int idx;

	public A1Pair(int start, int end, int idx) {
		this.start = start;
		this.end = end;
		this.idx = idx;
	}
}
