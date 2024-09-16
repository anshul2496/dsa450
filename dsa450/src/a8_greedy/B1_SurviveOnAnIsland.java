package a8_greedy;

/*
 * https://www.geeksforgeeks.org/problems/check-if-it-is-possible-to-survive-on-island4922/1
 * https://www.youtube.com/watch?v=tmgTdnCXgL4
 */
public class B1_SurviveOnAnIsland {
	public static void main(String[] args) {
		int s = 27, n = 20, m = 5;
		int ans = minimumDays(s, n, m);
		System.out.println(ans);
	}

	private static int minimumDays(int s, int n, int m) {
		int ans = 0;
		if (n < m || ((m * 7 > n * 6) && s > 6))
			return -1;
		ans = (m * s) / n;
		if ((m * s) % n != 0)
			ans++;
		return ans;
	}
}
