package b2_heaps;

import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
 * https://www.youtube.com/watch?v=eccAKrmffh8
 */
public class A7_KthLargestSumContgSubArray {
	public static void main(String[] args) {

	}

	public static int kthLargest(int[] arr, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = i; j < n; j++) {
				sum = sum + arr[j];
				if (pq.size() < k)
					pq.add(sum);
				else {
					if (sum > pq.peek()) {
						pq.remove();
						pq.add(sum);
					}
				}
			}
		}
		return pq.peek();
	}
}
