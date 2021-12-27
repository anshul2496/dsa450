package a1_arrays;

import java.util.Arrays;

public class A9_MinimiseMaxDiffBetweenHeights {

	/*
	 * https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1
	 * Given an array arr[] denoting heights of N towers and a positive integer K,
	 * you have to modify the height of each tower either by increasing or
	 * decreasing them by K only once. After modifying, height should be a
	 * non-negative integer. Find out what could be the possible minimum difference
	 * of the height of shortest and longest towers after you have modified each
	 * tower. Example 1: Input: K = 2, N = 4 Arr[] = {1, 5, 8, 10} Output: 5
	 * Explanation: The array can be modified as {3, 3, 6, 8}. The difference
	 * between the largest and the smallest is 8-3 = 5.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] arr = { 1, 5, 8, 10 };
		int k = 2;
		int n = arr.length;
		Arrays.sort(arr);
        int ans = arr[n-1]-arr[0];
        int min = arr[0]+k;
        int max = arr[n-1]-k;
        for(int i = 1;i<n;i++){
            if(arr[i]>=k){
                min = Math.min(arr[0]+k, arr[i]-k);
                max = Math.max(arr[n-1]-k, arr[i-1]+k);
                ans = Math.min(ans, max-min);
            }
        }
		System.out.println(ans);
	}

}
