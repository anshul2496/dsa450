package a1_arrays;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class C3_FactorialOfALargeNum {
	/*
	 * https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1
	 * https://www.youtube.com/watch?v=vxPBrr5x2jk Given an integer N, find its
	 * factorial. Example 1: Input: N = 5 Output: 120 Explanation : 5! = 1*2*3*4*5 =
	 * 120
	 */
	public static void main(String[] args) {
		// solution1();
		// solution2();
		solution3();
	}

	private static void solution3() {
		List<Integer> result = new ArrayList<>();
		int size = 0, c = 0;
		int n = 5;
		result.add(0, 1);
		size = 1;
		int val = 2;
		while (val <= n) {
			for (int i = size - 1; i >= 0; i--) {
				int temp = result.get(i) * val + c;
				result.set(i, temp % 10);
				c = temp / 10;
			}
			while (c != 0) {
				result.add(0, c % 10);
				c = c / 10;
				size++;
			}
			val++;
		}
		System.out.println(result);
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
