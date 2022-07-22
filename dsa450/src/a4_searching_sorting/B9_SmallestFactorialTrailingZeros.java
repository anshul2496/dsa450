package a4_searching_sorting;

/*
 * https://practice.geeksforgeeks.org/problems/smallest-factorial-number5929/1
 * https://www.youtube.com/watch?v=0y6Hy5zLSkk
 * Formula based not logic - Leave
 */
public class B9_SmallestFactorialTrailingZeros {
	public static void main(String[] args) {
		int n = 6;
		int ans = findNum(n);
		System.out.println(ans);
	}

	private static int findNum(int n) {
		if (n == 1)
			return 5;
		int low = 0, high = 5 * n;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (fact(mid, n))
				high = mid;
			else
				low = mid + 1;
		}
		return low;
	}

	private static boolean fact(int mid, int n) {
		int prod = 5, c = 0;
		while (prod <= mid) {
			c += (mid / prod);
			prod *= 5;
		}
		return c >= n;
	}
}
