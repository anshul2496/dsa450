package a2_matrix;

/*
 * https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1
 * https://www.youtube.com/watch?v=SVFXEqn3Ceo
 * You tube link for explanation(if you forgot)
 * 	Given a matrix of size r*c. Traverse the matrix in spiral form.
	Example 1:
	Input:
	r = 4, c = 4
	matrix[][] = {{1, 2, 3, 4},
	           	  {5, 6, 7, 8},
	            {9, 10, 11, 12},
	            {13, 14, 15,16}}
	Output: 
	1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
 */
public class A1_SpiralTraversal {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int minrow = 0;
		int mincol = 0;
		int maxcol = a[0].length - 1;
		int maxrow = a.length - 1;
		int totalElem = 4 * 4; // no of rows*no of columns
		int count = 0;
		while (count < totalElem) {
			// top wall
			for (int i = minrow, j = mincol; j <= maxcol && count <= totalElem; j++) {
				System.out.print(a[i][j] + " ");
				count++;
			}
			minrow++;

			// right wall
			for (int i = minrow, j = maxcol; i <= maxrow && count <= totalElem; i++) {
				System.out.print(a[i][j] + " ");
				count++;
			}
			maxcol--;

			// bottom wall
			for (int i = maxrow, j = maxcol; j >= mincol && count <= totalElem; j--) {
				System.out.print(a[i][j] + " ");
				count++;
			}
			maxrow--;

			// left wall
			for (int i = maxrow, j = mincol; i >= minrow && count <= totalElem; i--) {
				System.out.print(a[i][j] + " ");
				count++;
			}
			mincol++;
		}
	}
}
