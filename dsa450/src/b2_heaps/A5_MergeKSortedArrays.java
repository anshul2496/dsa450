package b2_heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
 * https://www.youtube.com/watch?v=E5WSILx1q0Q
 */
public class A5_MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 3;
		ArrayList<Integer> ans = mergeKArrays(arr, k);
		System.out.println(ans);
	}

	public static ArrayList<Integer> mergeKArrays(int[][] arr, int k) {
		ArrayList<Integer> ans = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			Pair p = new Pair(i, 0, arr[i][0]);
			pq.add(p);
		}
		while (!pq.isEmpty()) {
			Pair p = pq.remove();
			ans.add(p.val);
			p.colIndex++;
			if (p.colIndex < k) {
				p.val = arr[p.rowIndex][p.colIndex];
				pq.add(p);
			}
		}
		return ans;
	}
}

class Pair implements Comparable<Pair> {
	int rowIndex;
	int colIndex;
	int val;

	public Pair(int rowIndex, int colIndex, int val) {
		this.rowIndex = rowIndex;
		this.colIndex = colIndex;
		this.val = val;
	}

	public int compareTo(Pair o) {
		return this.val - o.val;
	}

	@Override
	public String toString() {
		return "Pair [rowIndex=" + rowIndex + ", colIndex=" + colIndex + ", val=" + val + "]";
	}
	
}