package a1_arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 * https://www.youtube.com/watch?v=fnbImb8lo88
 * Given an array arr[] and a number K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct. Example 1: Input: N = 6 arr[] = 7 10 4
 * 3 20 15 K = 3 Output : 7 Explanation : 3rd smallest element in the given
 * array is 7.
 */
public class A3_KthMaxMinElementInArray {

	public static void main(String[] args) {
		// Time : O(nlogk) bec. loop running n times for pq of size k; Space:O(k) as
		// size of PQ is never greater than k
		solution1();

		// Time:O(n) Space:O(1) - Quick select Algo
		// https://www.youtube.com/watch?v=fnbImb8lo88
		solution2();
	}

	private static void solution2() {
		// Kth smallest element
		int[] a = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		int kthSmallest = quickSelect(a, 0, a.length - 1, k - 1);
		System.out.println("Kth Smallest via Quick Select=" + kthSmallest);
		
		// For kth largest using quick select, we need to sort the array in descending order
		// For that in the partition function, just change to "if(a[i] < pivot) i++;"
		// https://leetcode.com/problems/kth-largest-element-in-an-array/
	}

	private static int quickSelect(int[] a, int low, int high, int k) {
		int pivot = a[high];
		int pi = partition(a, pivot, low, high);
		if (k > pi)
			return quickSelect(a, pi + 1, high, k);
		else if (k < pi)
			return quickSelect(a, low, pi - 1, k);
		else
			return a[pi];
	}

	private static int partition(int[] a, int pivot, int low, int high) {
		int i = low;
		int j = low;
		while (i <= high) {
			if (a[i] > pivot)
				i++;
			else {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j++;
			}
		}
		return j - 1;
	}

	private static void solution1() {
		int[] a = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		// Kth Largest - Min Heap - By default in Priority Queue
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			queue.add(a[i]);
		}
		for (int i = k; i < a.length; i++) {
			if (queue.peek() < a[i]) {
				queue.remove();
				queue.add(a[i]);
			}
		}
		System.out.println("Kth largest = " + queue.peek());

		// Kth Min - Max Heap - Collections.reverseOrder in Priority queue
		PriorityQueue<Integer> queue2 = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < k; i++) {
			queue2.add(a[i]);
		}
		for (int i = k; i < a.length; i++) {
			if (queue2.peek() > a[i]) {
				queue2.remove();
				queue2.add(a[i]);
			}
		}
		System.out.println("Kth smallest = " + queue2.peek());
	}
}
