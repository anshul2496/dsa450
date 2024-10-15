package b2_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 * https://www.youtube.com/watch?v=taL2G6jDLog
 */
public class A4_KLargestEle {
	public static void main(String[] args) {

	}

	int[] kLargest(int[] arr, int n, int k) {
		int[] ans = new int[k];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++)
			pq.add(arr[i]);
		for (int i = 0; i < k; i++)
			ans[i] = pq.poll();
		return ans;
	}
}
