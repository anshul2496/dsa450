package b2_heaps;

import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/minimum-cost-of-ropes-1587115620/1
 * https://www.youtube.com/watch?v=_9F2VgZcvdw
 */
public class B4_ConnectRopesWithMinCost {
	public static void main(String[] args) {

	}

	public long minCost(long[] arr) {
		long cost = 0;
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 0; i < arr.length; i++)
			pq.add(arr[i]);
		while (pq.size() > 1) {
			long a = pq.poll();
			long b = pq.poll();
			long sum = a + b;
			cost = cost + sum;
			pq.add(sum);
		}
		return cost;
	}
}
