 package arrays;

public class B8_FindAllPairsOnIntArray {

	/*
	 * https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1
	 * Given an array of N integers, and an integer K, find the number of pairs of
	 * elements in the array whose sum is equal to K.
	 * Example 1:
	 * Input: N = 4, K = 6 arr[] = {1, 5, 7, 1} Output: 2 Explanation: arr[0] +
	 * arr[1] = 1 + 5 = 6 and arr[1] + arr[3] = 5 + 1 = 6.
	 */
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		int[] a = { 1, 5, 7, 1 };
		int k = 6;
		int i = 0;
		int count = 0;
		int j = a.length - 1;
		while (i < a.length - 1) {
			if (a[i] + a[j] == k) {
				count++;
			}
			j--;
			if (j == i) {
				i++;
				j = a.length - 1;
			}
		}
		System.out.println(count);
	}
}
