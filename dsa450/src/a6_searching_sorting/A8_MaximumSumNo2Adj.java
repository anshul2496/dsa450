package a6_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
 */
public class A8_MaximumSumNo2Adj {
	public static void main(String[] args) {
		int[] a = { 5, 5, 10, 100, 10, 5 };
		int sum = 0;
		int i = 0;
		int j = 1;
		int sum1 = 0;
		while (i < a.length && j < a.length) {
			sum += a[i];
			sum1 += a[j];
			i += 2;
			j += 2;
		}
		System.out.println(Math.max(sum, sum1));
	}
}
