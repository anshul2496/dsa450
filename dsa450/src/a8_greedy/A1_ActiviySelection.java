package a8_greedy;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * https://www.youtube.com/watch?v=II6ziNnub1Q
 */
public class A1_ActiviySelection {
	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };
		int ans = maxMeetings(start, end, start.length);
		System.out.println(ans);
	}

	public static int maxMeetings(int start[], int end[], int n) {
		Meet[] meetings = new Meet[n];
		for (int i = 0; i < n; i++) {
			Meet m = new Meet(start[i], end[i]);
			meetings[i] = m;
		}
		Arrays.sort(meetings);
		int ans = 1;
		int lastEnd = meetings[0].end;
		for (int i = 1; i < n; i++) {
			if (meetings[i].start > lastEnd) {
				ans++;
				lastEnd = meetings[i].end;
			}
		}
		return ans;
	}
}

class Meet implements Comparable<Meet> {
	int start;
	int end;
	// No need of including the index, it is still passing all test cases
	public Meet(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int compareTo(Meet other) {
		return this.end - other.end;
	}
}
