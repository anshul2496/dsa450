package a6_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/searching-in-an-array-where-adjacent-differ-by-at-most-k0456/1/
 * https://www.youtube.com/watch?v=s_IYrsRhxtw
 */
public class A5_SearchWhereAdjDifferByK {
	public static void main(String[] args) {
		int[] a = { 4, 5, 6, 7, 6 };
		int k = 1;
		int x = 6;
		int i = 0;
		while (i < a.length) {
			if (a[i] == x)
				break;
			int steps = Math.abs(x - a[i]) / k;
			i = i + Math.max(1, steps);
		}
		System.out.println(i);
	}
}
