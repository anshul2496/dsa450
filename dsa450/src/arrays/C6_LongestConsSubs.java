package arrays;

import java.util.HashSet;

/*
 * 	https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
 * 	Given an array of positive integers. Find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.
	Example 1:
	Input:
	N = 7
	a[] = {2,6,1,9,4,5,3}
	Output:
	6
	Explanation:
	The consecutive numbers here are 1, 2, 3, 4, 5, 6. These 6 numbers form the longest consecutive subsquence.
 */
public class C6_LongestConsSubs {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 1, 9, 4, 5, 3 };
		HashSet<Integer> set = new HashSet<>();
		int ans = 0;
		for (int i = 0; i < arr.length; ++i)
			set.add(arr[i]);

		for (int i = 0; i < arr.length; ++i) {
			// if current element is the starting
			// element of a sequence
			if (!set.contains(arr[i] - 1)) {
				// Then check for next elements
				// in the sequence
				int j = arr[i];
				while (set.contains(j))
					j++;

				// update optimal length if this
				// length is more
				if (ans < j - arr[i])
					ans = j - arr[i];
			}
		}
		System.out.println(ans);
	}
}
