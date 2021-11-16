package a1_arrays;

import java.util.Iterator;
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
		solution1_treeSet();
		// Check url for more solutions. Go for heap solution.
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
