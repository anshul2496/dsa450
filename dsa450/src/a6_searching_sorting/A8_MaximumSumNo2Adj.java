package a6_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1
 * https://www.youtube.com/watch?v=VT4bZV24QNo
 */
public class A8_MaximumSumNo2Adj {
	public static void main(String[] args) {
		int[] a = { 5, 5, 10, 100, 10, 5 };
		int inc = a[0];
		int exc = 0;
		for (int i = 1; i < a.length; i++) {
			int ninc = exc + a[i];
			int nexc = Math.max(exc, inc);
			inc = ninc;
			exc = nexc;
		}
		int ans = Math.max(inc, exc);
		System.out.println(ans);
	}
}
