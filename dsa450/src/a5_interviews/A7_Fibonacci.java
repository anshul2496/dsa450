package a5_interviews;

/*
 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * The Fibonacci numbers are the numbers in the following integer sequence.
	0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
	Get nth Fibonacci number
 */
public class A7_Fibonacci {
	public static void main(String[] args) {
		int n = 9;
		System.out.println(getFib(n));
	}

	private static int getFib(int n) {
		if (n <= 1)
			return n;
		return getFib(n - 1) + getFib(n - 2);
	}
}
