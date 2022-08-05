package a2_matrix;

/*
 * https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
 * https://www.codingninjas.com/codestudio/problems/median-of-a-row-wise-sorted-matrix_1115473
 * https://www.youtube.com/watch?v=tFdBRcHLSGQ
 * Given a row wise sorted matrix of size RxC where R and C are always odd, find the median of the matrix.
	Example 1:
	Input:
	R = 3, C = 3
	M = [[1, 3, 5], 
	     [2, 6, 9], 
	     [3, 6, 9]]
	Output: 5
	Explanation:
	Sorting matrix elements gives us 
	{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
	Complexity - log(range)*(number of rows)*log(column)
 */
public class B1_MedianInRowSorted {
	public static void main(String[] args) {
		int[][] a = { { 1, 3, 5 }, { 2, 6, 9 }, { 3, 6, 9 } };
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int rows = 3;
		int cols = 3;
		int n = rows * cols;
		for (int i = 0; i < rows; i++) {
			if (a[i][0] < min)
				min = a[i][0];
			if (a[i][cols - 1] > max)
				max = a[i][cols - 1];
		}
		while (min <= max) {
			int midVal = (min + max) / 2;
			int ans = 0;
			for (int i = 0; i < rows; i++) {
				int low = 0;
				int high = cols - 1;
				while (low <= high) {
					int mid = low + (high - low) / 2;
					if (midVal >= a[i][mid])
						low = mid + 1;
					else
						high = mid - 1;
				}
				// With the help of binary search in each row we are finding that how many elements are smaller than midval
				// The total no of smaller elements we are adding in ans each time and then checking if ans contains the exact number of elements
				// which needed to be less than n/2. By doing, so we make sure that min comes to the median
				ans = ans + low;
			}
			if (ans <= n / 2)
				min = midVal + 1;
			else
				max = midVal - 1;
		}
		System.out.println(min);
	}
}
