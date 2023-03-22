package a1_arrays;

import java.util.HashMap;

/*
 * https://practice.geeksforgeeks.org/problems/count-element-occurences/1
 * https://www.youtube.com/watch?v=ChK9pQDhIrk
 * Given an array of size n, find all elements in array that appear more than n/k times. 
 * For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. 
 * Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. 
 * There are two elements that appear more than two times, 2 and 3.
 */
public class C53_ElementsAppearNByKTimes {
	public static void main(String[] args) {
		int[] a = { 3, 1, 2, 2, 1, 2, 3, 3 };
		int k = 4;
		System.out.println(countOccurence(a, a.length, k));
	}

	public static int countOccurence(int[] a, int n, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int ans = 0;
		int times = n / k;
		for (int i = 0; i < n; i++) {
			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}
		for (int key : map.keySet()) {
			if (map.get(key) > times)
				ans++;
		}
		return ans;
	}
}
