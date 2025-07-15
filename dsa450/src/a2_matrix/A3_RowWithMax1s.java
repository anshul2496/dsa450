package a2_matrix;

/*
 * https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1
 * https://www.youtube.com/watch?v=cWKLH1BDsIg
 * Given a boolean 2D array of n x m dimensions where each row is sorted. 
 * Find the 0-based index of the first row that has the maximum number of 1's.
	Example 1:
	Input: 
	N = 4 , M = 4
	Arr[][] = {{0, 1, 1, 1},
	           {0, 0, 1, 1},
	           {1, 1, 1, 1},
	           {0, 0, 0, 0}}
	Output: 2
	Explanation: Row 2 contains 4 1's (0-based indexing).
 */
public class A3_RowWithMax1s {
	public static void main(String[] args) {
		solution1();
	}

	private static void solution1() {
		/*
		 * As the rows are sorted we can apply binary search on each row to get the
		 * count of first 1. Rest of the 1's will be after that
		 */
		int[][] a = { { 0, 1, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } };
		int rows = 4;
		int count = 0;
		int ansCount = 0;
		int ansRow = 0;
		for (int i = 0; i < rows; i++) {
			count = binarySearch(a, i);
			if (count > ansCount) {
				ansCount = count;
				ansRow = i;
			}
		}
		System.out.println(ansRow);
	}

	private static int binarySearch(int[][] a, int i) {
		int low = 0;
		int high = a[0].length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (a[i][mid] == 1) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		int ans = a[0].length - low;
		return ans;
	}
}
