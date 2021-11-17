package a2_matrix;

/*
 * https://practice.geeksforgeeks.org/problems/kth-element-in-matrix/1
 * https://www.youtube.com/watch?v=LkrsdWa69_Q
 * Given a N x N matrix, where every row and column is sorted in non-decreasing order. Find the kth smallest element in the matrix.
	Example 1:
	Input:
	N = 4
	mat[][] =     {{16, 28, 60, 64},
                   {22, 41, 63, 91},
                   {27, 50, 87, 93},
                   {36, 78, 87, 94 }}
	K = 3
	Output: 27
	Explanation: 27 is the 3rd smallest element.
 */
public class A8_KthSmallestElement {
	public static void main(String[] args) {
		int[][] a = { { 16, 28, 60, 64 }, { 22, 41, 63, 91 }, { 27, 50, 87, 93 }, { 36, 78, 87, 94 } };
		int rows = a.length;
		int cols = a[0].length;
		int startVal = a[0][0];
		int endVal = a[rows - 1][cols - 1];
		int midVal;
		int k = 3;
		while (startVal <= endVal) {
			midVal = (startVal + endVal) / 2;
			int ans = 0;
			// Row wise traversing the matrix
			for (int i = 0; i < rows; i++) {
				// Applying binary search on each row
				int low = 0, high = cols - 1, mid;
				while (low <= high) {
					mid = low + (high - low) / 2;
					if (a[i][mid] <= midVal)
						low = mid + 1;
					else
						high = mid - 1;
				}
				ans = ans + low;
			}
			if (ans < k)
				startVal = midVal + 1;
			else
				endVal = midVal - 1;
		}
		System.out.println(startVal);
	}
}
