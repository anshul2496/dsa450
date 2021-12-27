package a1_arrays;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class A3_KthMaxMinElementInArray {

	/*
	 * https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
	 * 
	 * Given an array arr[] and a number K where K is smaller than size of array,
	 * the task is to find the Kth smallest element in the given array. It is given
	 * that all array elements are distinct. Example 1: Input: N = 6 arr[] = 7 10 4
	 * 3 20 15 K = 3 Output : 7 Explanation : 3rd smallest element in the given
	 * array is 7.
	 */
	public static void main(String[] args) {
		// solution1_treeSet();
		solution2();
	}

	private static void solution2() {
		int[] a = { 7, 10, 4, 3, 20, 15 };
		int k = 3;
		// Kth Largest - Min Heap - By default in Priority Queue
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			queue.add(a[i]);
		}
		for (int i = k; i < a.length; i++) {
			if (queue.peek() < a[i]) {
				queue.poll();
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
				queue2.poll();
				queue2.add(a[i]);
			}
		}
		System.out.println("Kth smallest = " + queue2.peek());
	}

	private static void solution1_treeSet() {
		Scanner ob = new Scanner(System.in);
		System.out.println("N=");
		int n = ob.nextInt();
		int i = 1;
		Set<Integer> treeSet = new TreeSet<>();
		while (i <= n) {
			System.out.println("Enter a number=");
			treeSet.add(ob.nextInt());
			i++;
		}
		System.out.println("Enter k=");
		int k = ob.nextInt();
		i = 0;
		if (n >= (k - 1)) {
			Iterator<Integer> it = treeSet.iterator();
			while (it.hasNext()) {
				if (i == (k - 1)) {
					System.out.println(k + " smallest number=" + it.next());
					break;
				}
				i++;
				it.next();
			}
		}
		ob.close();
	}
}
