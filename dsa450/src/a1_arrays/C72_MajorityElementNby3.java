package a1_arrays;

import java.util.ArrayList;

/*
 * https://leetcode.com/problems/majority-element-ii/
 * https://www.youtube.com/watch?v=1QybAZMCYhA
 * Given an integer array of size n, find all elements that appear more than n/3 times.
	Input: nums = [3,2,3]
	Output: [3]
 */
public class C72_MajorityElementNby3 {
	public static void main(String[] args) {
		int[] a = { 3, 2, 3 };
		ArrayList<Integer> list = getMajorityElements(a);
		System.out.println(list);
	}

	private static ArrayList<Integer> getMajorityElements(int[] a) {
		int val1 = a[0];
		int count1 = 1;
		int val2 = a[0];
		int count2 = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i < a.length; i++) {
			if (val1 == a[i]) {
				count1++;
			} else if (val2 == a[i]) {
				count2++;
			} else {
				if (count1 == 0) {
					val1 = a[i];
					count1 = 1;
				} else if (count2 == 0) {
					val2 = a[i];
					count2 = 1;
				} else {
					count1--;
					count2--;
				}
			}
		}
		if (isGreaterThanNBy3(a, val1)) {
			list.add(val1);
		}
		if (val1 != val2 && isGreaterThanNBy3(a, val2)) {
			list.add(val2);
		}
		return list;
	}

	private static boolean isGreaterThanNBy3(int[] a, int val) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == val) {
				count++;
			}
		}
		return count > (a.length / 3);
	}
}
