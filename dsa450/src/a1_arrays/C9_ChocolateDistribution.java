package a1_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * 	https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
 * 	Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. 
 * 	Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that
	1. Each student gets exactly one packet.
	2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.
	Input:
	N = 8, M = 5
	A = {3, 4, 1, 9, 56, 7, 9, 12}
	Output: 6
	The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.
 */
public class C9_ChocolateDistribution {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 3, 4, 1, 9, 56, 7, 9, 12 };
		int m = 5;
		Arrays.sort(a);
		int min = Integer.MAX_VALUE;
		int low = 0;
		int high = m - 1;
		while (high < a.length) {
			min = Math.min(min, a[high] - a[low]);
			low++;
			high++;
		}
		System.out.println(min);
	}
	
	// GFG Soln
	public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        long ans=Long.MAX_VALUE;
        Collections.sort(a);
        int j=m-1;
        for(int i=0;i<=n-m;i++){
            ans=Math.min(ans,a.get(j)-a.get(i));
            j++;
        }
        return ans;
    }
}
