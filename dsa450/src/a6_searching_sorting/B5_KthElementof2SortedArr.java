package a6_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
 * https://www.youtube.com/watch?v=nv7F4PiLUzo
 * *****This is same as median of two sorted arrays.*****
 * Input:
	arr1[] = {2, 3, 6, 7, 9}
	arr2[] = {1, 4, 8, 10}
	k = 5
	Output:
	6
	Explanation:
	The final sorted array would be - 1, 2, 3, 4, 6, 7, 8, 9, 10 The 5th element of this array is 6.
 */
public class B5_KthElementof2SortedArr {
	public static void main(String[] args) {
		int[] a = { 2, 3, 6, 7, 9 };
		int[] b = { 1, 4, 8, 10 };
		int k = 5;
		int kthElement = getKthElement(a, b, k);
		System.out.println(kthElement);
	}

	private static int getKthElement(int[] a, int[] b, int k) {
		if (a.length > b.length)
			return getKthElement(b, a, k);
		int n1 = a.length;
		int n2 = b.length;
		int low = 0;
		int high = n1;
		while (low <= high) {
			int cut1 = (low + high) / 2;
			int cut2 = k - cut1;
			int l1 = (cut1 == 0) ? Integer.MIN_VALUE : a[cut1 - 1];
			int l2 = (cut2 == 0) ? Integer.MIN_VALUE : b[cut2 - 1];
			int r1 = (cut1 == n1) ? Integer.MAX_VALUE : a[cut1];
			int r2 = (cut2 == n2) ? Integer.MAX_VALUE : b[cut2];
			if (l1 > r2) {
				high = cut1 - 1;
			} else if (l2 > r1) {
				low = cut1 + 1;
			} else {
				return Math.max(l1, l2);
			}
		}
		return 0;
	}
}
