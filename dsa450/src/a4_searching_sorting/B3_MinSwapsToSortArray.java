package a4_searching_sorting;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/minimum-swaps/1
 * https://www.youtube.com/watch?v=m-8_yQao-lI
 */
public class B3_MinSwapsToSortArray {
	public static void main(String[] args) {
		int[] a = { 10, 19, 6, 3, 5 };
		int ans = 0;
		Pair[] arr = new Pair[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = new Pair(a[i], i);
		}
		Arrays.sort(arr);
		boolean[] vi = new boolean[a.length];
		for (int i = 0; i < a.length; i++) {
			if (vi[i] == true || arr[i].idx == i) {
				continue;
			}
			int j = i;
			int clen = 0;
			while (vi[j] == false) {
				vi[j] = true;
				clen++;
				j = arr[j].idx;
			}
			ans += (clen - 1);
		}
		System.out.println(ans);
	}
}

class Pair implements Comparable<Pair> {
	int val;
	int idx;

	public Pair(int val, int idx) {
		this.val = val;
		this.idx = idx;
	}

	@Override
	public int compareTo(Pair o) {
		return this.val - o.val;
	}
}