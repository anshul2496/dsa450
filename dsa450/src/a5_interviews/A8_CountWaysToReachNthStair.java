package a5_interviews;

/*
 * https://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * https://www.techiedelight.com/find-total-ways-reach-nth-stair-with-atmost-m-steps/
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. 
 * Count the number of ways, the person can reach the top.
 */
public class A8_CountWaysToReachNthStair {
	public static void main(String[] args) {
		int n = 4;
		System.out.println("Number of ways = " + countWays(n));

		// Upto M steps
		int m = 3;
		int[] lookup = new int[n + 1];
		System.out.println("Number of ways = " + countWaysMSteps(n, m, lookup));
	}

	private static int countWays(int n) {
		return getFib(n + 1);
	}

	private static int getFib(int n) {
		if (n <= 1)
			return n;
		return getFib(n - 1) + getFib(n - 2);
	}

	private static int countWaysMSteps(int n, int m, int[] lookup) {
		if (n < 0)
			return 0;
		if (n == 0)
			return 1;

		if (lookup[n] == 0) {
			for (int i = 1; i <= m; i++) {
				lookup[n] += countWaysMSteps(n - i, m, lookup);
			}
		}
		return lookup[n];
	}

}
