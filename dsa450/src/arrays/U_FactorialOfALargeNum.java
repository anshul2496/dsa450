package arrays;

import java.math.BigInteger;

public class U_FactorialOfALargeNum {
	/*
	 * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
	 * 
	 * Given an integer N, find its factorial.
	 * Example 1:
	 * Input: N = 5 Output: 120 Explanation : 5! = 1*2*3*4*5 = 120
	 */
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		int n = 5;
		BigInteger bg = new BigInteger("1");
		for (int i = 2; i <= n; i++) {
			bg = bg.multiply(BigInteger.valueOf(i));
		}
		System.out.println(bg);
	}

	private static void solution1() {
		int n = 5;
		int fact = getFact(n);
		System.out.println(fact);
	}

	private static int getFact(int n) {
		if (n == 1) {
			return 1;
		}
		return n * getFact(n - 1);
	}
}
