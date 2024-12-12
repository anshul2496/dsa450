package interviews;

/*
 * https://www.geeksforgeeks.org/problems/nth-fibonacci-number1335/1
 * https://www.youtube.com/watch?v=94dfRrDANRY
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
		int fibm = getFibWithMemoization(n - 1, qb) + getFibWithMemoization(n - 2, qb);
		qb[n] = fibm;
		return fibm;
	}

	private static int getFib(int n) {
		if (n == 0 || n == 1)
			return n;
		return getFib(n - 1) + getFib(n - 2);
	}
}
