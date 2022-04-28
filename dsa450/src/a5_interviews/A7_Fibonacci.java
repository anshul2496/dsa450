package a5_interviews;

/*
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * https://www.youtube.com/watch?v=94dfRrDANRY&list=PL-Jc9J83PIiG8fE6rj9F5a6uyQ5WPdqKy&index=1
 * The Fibonacci numbers are the numbers in the following integer sequence.
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
	Get nth Fibonacci number
 */
public class A7_Fibonacci {
	public static void main(String[] args) {
		int n = 9;
		System.out.println(getFib(n));
		System.out.println(getFibWithMemoization(n, new int[n + 1]));
	}

	private static int getFibWithMemoization(int n, int[] qb) {
		if (n == 0 || n == 1)
			return n;
		if (qb[n] != 0)
			return qb[n];
		int fibm1 = getFib(n - 1);
		int fibm2 = getFib(n - 2);
		int fibm = fibm1 + fibm2;
		qb[n] = fibm;
		return fibm;
	}

	private static int getFib(int n) {
		if (n == 0 || n == 1)
			return n;
		int fibm1 = getFib(n - 1);
		int fibm2 = getFib(n - 2);
		int fibm = fibm1 + fibm2;
		return fibm;
	}
}
