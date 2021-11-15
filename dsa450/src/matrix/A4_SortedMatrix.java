package matrix;

import java.util.Arrays;

/*
 * https://practice.geeksforgeeks.org/problems/sorted-matrix2333/1
	Given an NxN matrix Mat. Sort all elements of the matrix.
	Example 1:
	Input:
	N=4
	Mat=[[10,20,30,40],
	[15,25,35,45] 
	[27,29,37,48] 
	[32,33,39,50]]
	Output:
	10 15 20 25 
	27 29 30 32
	33 35 37 39
	40 45 48 50
	Explanation:
	Sorting the matrix gives this result.
 */
public class A4_SortedMatrix {
	public static void main(String[] args) {
		int[][] a = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		int rows = a.length;
		int cols = a[0].length;
		int[] temp = new int[rows * cols];
		int k = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				temp[k++] = a[i][j];
			}
		}
		Arrays.sort(temp);
		k = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				a[i][j] = temp[k++];
			}
		}
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
