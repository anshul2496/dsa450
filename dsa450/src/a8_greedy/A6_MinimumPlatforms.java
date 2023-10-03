package a8_greedy;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 * https://www.youtube.com/watch?v=FkJZlZHWUyk
 */
public class A6_MinimumPlatforms {
	public static void main(String[] args) {
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		int n = 6;
		int ans = findPlatform(arr, dep, n);
		System.out.println(ans);
	}

	private static int findPlatform(int[] arr, int[] dep, int n) {
		Arrays.sort(arr);
		Arrays.sort(dep);
		int ans = 0, i = 0, j = 0, count = 0;
		while (i < n && j < n) {
			if (arr[i] <= dep[j]) {
				count++;
				ans = Math.max(ans, count);
				i++;
			} else {
				count--;
				j++;
			}
		}
		return ans;
	}
}
