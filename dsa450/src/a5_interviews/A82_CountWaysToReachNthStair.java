package a5_interviews;

/*
 * https://leetcode.com/problems/climbing-stairs/
 * https://www.youtube.com/watch?v=A6mOASLl2Dg
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. 
 * Count the number of ways, the person can reach the top.
 */
public class A82_CountWaysToReachNthStair {
	public static void main(String[] args) {
		int n = 4;
		// Without memorization
		System.out.println("Number of ways = " + countWays(n));

		// With memorization
		System.out.println("Number of ways = " + countWaysWithMemoization(n, new int[n + 1]));

		// With Tabulization -> In tabulization we solve with iteration not recursion
		System.out.println("Number of ways = " + countWaysWithTabulization(n));
	}

	private static int countWaysWithTabulization(int n) {
		int[] dp = new int[n + 1];

		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = dp[i - 1];
			} else if (i == 2) {
				dp[i] = dp[i - 1] + dp[i - 2];
			} else {
				dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
			}
		}
		return dp[n];
	}

	private static int countWaysWithMemoization(int n, int[] qb) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		if (qb[n] != 0) {
			return qb[n];
		}
		int nm1 = countWaysWithMemoization(n - 1, qb);
		int nm2 = countWaysWithMemoization(n - 2, qb);
		int nm3 = countWaysWithMemoization(n - 3, qb);
		int cp = nm1 + nm2 + nm3;
		qb[n] = cp;
		return cp;
	}

	private static int countWays(int n) {
		if (n == 0) {
			return 1;
		} else if (n < 0) {
			return 0;
		}
		int nm1 = countWays(n - 1);
		int nm2 = countWays(n - 2);
		int nm3 = countWays(n - 3);
		int cp = nm1 + nm2 + nm3;
		return cp;
	}
}