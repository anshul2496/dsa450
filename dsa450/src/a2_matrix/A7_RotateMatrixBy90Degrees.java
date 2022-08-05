package a2_matrix;

/*
 * https://leetcode.com/problems/rotate-image/
 * https://www.youtube.com/watch?v=SoxrXQbhCPI
	Input:
	1 2 3 
	4 5 6
	7 8 9  
	Output:
	7 4 1 
	8 5 2
	9 6 3
 */
public class A7_RotateMatrixBy90Degrees {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int rows = a.length;
		int cols = a[0].length;

		// Transpose
		for (int i = 0; i < rows; i++) {
			for (int j = i; j < cols; j++) {
				int temp = a[i][j];
				a[i][j] = a[j][i];
				a[j][i] = temp;
			}
		}

		// Reverse the rows one by one
		for (int i = 0; i < rows; i++) {
			int low = 0;
			int high = cols - 1;
			while (low < high) {
				int temp = a[i][low];
				a[i][low] = a[i][high];
				a[i][high] = temp;
				low++;
				high--;
			}
		}

		// Display
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
