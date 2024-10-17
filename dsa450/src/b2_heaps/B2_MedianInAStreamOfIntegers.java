package b2_heaps;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1
 * https://www.youtube.com/watch?v=dshWERdcAdg
 */
public class B2_MedianInAStreamOfIntegers {

}

class Solution {
	private static PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
	private static PriorityQueue<Integer> right = new PriorityQueue<>();

	// Function to insert heap.
	public static void insertHeap(int x) {
		if (!right.isEmpty() && x > right.peek())
			right.add(x);
		else
			left.add(x);
		balanceHeaps();
	}

	// Function to balance heaps.
	public static void balanceHeaps() {
		if (left.size() - right.size() == 2)
			right.add(left.remove());
		else if (right.size() - left.size() == 2)
			left.add(right.remove());
	}

	// Function to return Median.
	public static double getMedian() {
		if (left.size() > right.size())
			return (double) left.peek();
		else if (right.size() > left.size())
			return (double) right.peek();
		else
			return ((left.peek() + right.peek()) / 2.0);
	}

}
