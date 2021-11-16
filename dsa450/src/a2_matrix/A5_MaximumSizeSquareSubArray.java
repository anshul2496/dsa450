package matrix;

/*
 * https://practice.geeksforgeeks.org/problems/max-rectangle/1
 * https://www.youtube.com/watch?v=UagRoA3C5VQ
 * Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.
	Example 1:
	Input:
	n = 4, m = 4
	M[][] = {{0 1 1 0},
	         {1 1 1 1},
	         {1 1 1 1},
	         {1 1 0 0}}
	Output: 4
	Explanation: For the above test case the
	matrix will look like
	0 1 1 0
	1 1 1 1
	1 1 1 1
	1 1 0 0
	the max size square is 
	1 1
	1 1
	and area is 2 *2 = 4.
 */
public class A5_MaximumSizeSquareSubArray {
	public static void main(String[] args) {
		int[][] a = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		int rows = a.length;
		int cols = a[0].length;
		int ans = 0;
		int[][] s = new int[rows][cols];
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (i == rows - 1) {
					s[i][j] = a[i][j];
				} else if (j == cols - 1) {
					s[i][j] = a[i][j];
				} else {
					if (a[i][j] == 0)
						s[i][j] = a[i][j];
					else {
						int min = Math.min(s[i + 1][j], s[i][j + 1]);
						min = Math.min(min, s[i + 1][j + 1]);
						s[i][j] = min + 1;
						ans = Math.max(ans, s[i][j]);
					}
				}
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println(ans * ans);
	}
}
