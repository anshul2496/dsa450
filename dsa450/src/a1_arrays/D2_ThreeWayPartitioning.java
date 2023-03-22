package a1_arrays;

import java.util.Arrays;

/*
 * 	https://practice.geeksforgeeks.org/problems/three-way-partitioning/1
 * 	Given an array of size n and a range [a, b]. The task is to partition the array around the range such that array is divided into three parts.
	1) All elements smaller than a come first.
	2) All elements in range a to b come next.
	3) All elements greater than b appear in the end.
	The individual elements of three sets can appear in any order. You are required to return the modified array.
	Input: 
	n = 5
	A[] = {1, 2, 3, 3, 4}
	[a, b] = [1, 2]
	Output: 1
	Explanation: One possible arrangement is: {1, 2, 3, 3, 4}. If you return a valid
	arrangement, output will be 1.Solution is same as A4 to sort array without any algo
 */
public class D2_ThreeWayPartitioning {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 3, 4 };
		int[] range = { 1, 2 };
		int start = 0;
		int end = a.length - 1;
		int temp;
		for (int i = 0; i <= end;) {
			if (a[i] < range[0]) {
				temp = a[start];
				a[start] = a[i];
				a[i] = temp;
				start++;
				i++;
			} else if (a[i] > range[1]) {
				temp = a[end];
				a[end] = a[i];
				a[i] = temp;
				end--;
			} else {
				i++;
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
