package arrays;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * There are 2 sorted arrays A and B of size n each. Write an algorithm to find the median of the array obtained after merging the above 2 arrays(i.e. array of length 2n). 
 * The complexity should be O(log(n)). 
 * Input : a1[] = {1,12,15,26,38}
 * a2[] = {2,13,17,30,45}
 * Output = 16
 * Explanation: After merging two arrays we get {1,2,12,13,15,17,26,30,38,45}
 * Middle two elements are 15 and 17
 * Average of middle elements is (15+17)/2 which is equal to 16
 */
public class D8_MedianOf2SortedArraysSameSize {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 1, 12, 15, 26, 38 };
		int[] b = { 2, 13, 17, 30, 45 };
		int[] c = new int[a.length + b.length];
		int j = 0, i = 0;
		int k = 0;
		for (i = 0; i < a.length && j < b.length;) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (k < c.length && j < b.length) {
			c[k++] = b[j++];
		}
		while (k < c.length && i < a.length) {
			c[k++] = b[j++];
		}
		System.out.println(Arrays.toString(c));
		int median = 0;
		int mid = c.length / 2;
		if ((c.length - 1) % 2 == 0) {
			median = c[mid];
		} else {
			median = (c[mid - 1] + c[mid]) / 2;
		}
		System.out.println(median);
	}
}
