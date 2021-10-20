package arrays;

import java.util.HashSet;
import java.util.Set;

public class B2_FindDuplicatesInArray {

	/*
	 * https://leetcode.com/problems/find-the-duplicate-number/ Given an array of
	 * integers nums containing n + 1 integers where each integer is in the range
	 * [1, n] inclusive. There is only one repeated number in nums, return this
	 * repeated number. You must solve the problem without modifying the array nums
	 * and uses only constant extra space. Example 1: Input: nums = [1,3,4,2,2]
	 * Output: 2
	 */
	public static void main(String[] args) {
		// solution1_set();
		solution2_hareAndTortoise();
	}

	private static void solution2_hareAndTortoise() {
		int[] a = { 1, 2, 3, 4, 2, 3};
		int tortoise = a[0];
		int hare = a[0];
		// Find the intersection point of two runners
		do {
			tortoise = a[tortoise];
			hare = a[a[hare]];
		} while (hare != tortoise);

		// Find the entrance to the cycle(which has the duplicate)
		tortoise = a[0];
		while (tortoise != hare) {
			tortoise = a[tortoise];
			hare = a[hare];
		}
		System.out.println(hare);
	}

	private static void solution1_set() {
		int[] a = { 1, 2, 3, 4, 2, 3 };
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a.length; i++) {
			if (set.contains(a[i])) {
				System.out.println(a[i]);
			} else {
				set.add(a[i]);
			}
		}
	}
}
