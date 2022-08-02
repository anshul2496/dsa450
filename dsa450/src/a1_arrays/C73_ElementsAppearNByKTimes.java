package a1_arrays;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/arrays-and-strings/majority-element-general/ojquestion
 * https://www.youtube.com/watch?v=ChK9pQDhIrk
 * Given an array of size n, find all elements in array that appear more than n/k times. 
 * For example, if the input arrays is {3, 1, 2, 2, 1, 2, 3, 3} and k is 4, then the output should be [2, 3]. 
 * Note that size of array is 8 (or n = 8), so we need to find all elements that appear more than 2 (or 8/4) times. 
 * There are two elements that appear more than two times, 2 and 3.
 */
public class C73_ElementsAppearNByKTimes {
	public static void main(String[] args) {
		int[] a = { 3, 1, 2, 2, 1, 2, 3, 3 };
		int k = 4;
		int times = a.length / k;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (map.containsKey(a[i])) {
				map.put(a[i], map.get(a[i]) + 1);
				if (map.get(a[i]) > times)
					System.out.println(a[i]);
			} else
				map.put(a[i], 1);
		}
	}
}
