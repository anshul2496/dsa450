package a4_searching_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
 * https://www.youtube.com/watch?v=hGz0b8L7plI
 */
public class A7_FindAllFourSumNumbers {
	public static void main(String[] args) {
		int[] a = { 10, 2, 3, 4, 5, 7, 8 };
		int k = 23;
		ArrayList<ArrayList<Integer>> list = getFourSum(a, k);
		System.out.println(list);
	}

	private static ArrayList<ArrayList<Integer>> getFourSum(int[] a, int sum) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int n = a.length;
		if (n < 4)
			return ans;
		Arrays.sort(a);
		for (int i = 0; i <= n - 4; i++) {
			if (i != 0 && a[i] == a[i - 1])
				continue;
			int val1 = a[i];
			int target = sum - a[i];
			ArrayList<ArrayList<Integer>> temp = getThreeSum(a, target, i + 1);
			for (ArrayList<Integer> list : temp) {
				list.add(val1);
				Collections.sort(list);
				ans.add(list);
			}
		}
		return ans;
	}

	private static ArrayList<ArrayList<Integer>> getThreeSum(int[] a, int target, int si) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int n = a.length;
		if (n - si < 3)
			return ans;
		for (int i = si; i <= n - 3; i++) {
			if (i != si && a[i] == a[i - 1])
				continue;
			int val1 = a[i];
			int tar = target - a[i];
			ArrayList<ArrayList<Integer>> temp = getTwoSum(a, tar, i + 1);
			for (ArrayList<Integer> list : temp) {
				list.add(val1);
				ans.add(list);
			}
		}
		return ans;
	}

	private static ArrayList<ArrayList<Integer>> getTwoSum(int[] a, int tar, int si) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		int n = a.length;
		if ((n - si) < 2)
			return ans;
		int left = si;
		int right = n - 1;
		while (left < right) {
			if (left != si && a[left] == a[left - 1]) {
				left++;
				continue;
			}
			int sum = a[left] + a[right];
			if (sum == tar) {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(a[right]);
				list.add(a[left]);
				ans.add(list);
				left++;
				right--;
			} else if (sum > tar) {
				right--;
			} else {
				left++;
			}
		}
		return ans;
	}
}
