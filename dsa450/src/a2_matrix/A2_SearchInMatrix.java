package matrix;

/*
 * https://leetcode.com/problems/search-a-2d-matrix/
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	Example 1:
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
	Output: true
 */
public class A2_SearchInMatrix {
	public static void main(String[] args) {
		// solution1();
		solution2();
	}

	private static void solution2() {
		// Imagine this to be a single sorted array
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int rows = a.length;
		int cols = a[0].length;
		int low = 0;
		int high = (rows * cols) - 1;
		int key = 3;
		int flag = 0;
		while (low <= high) {
			int mid = (low + high) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (key == a[row][col]) {
				System.out.println("Found");
				flag = 1;
				break;
			} else if (key > a[row][col]) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (flag == 0)
			System.out.println("Number not found");
	}

	private static void solution1() {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		int minrow = 0;
		int mincol = 0;
		int maxrow = a.length - 1;
		int maxcol = a[0].length - 1;
		int key = 3;
		int flag = 0;
		for (minrow = 0; minrow <= maxrow; minrow++) {
			int low = mincol;
			int high = maxcol;
			while (low < high) {
				int midcol = (low + high) / 2;
				if (key == a[minrow][midcol]) {
					System.out.println("Found");
					flag = 1;
					break;
				} else if (key > a[minrow][midcol]) {
					low = midcol + 1;
				} else {
					high = midcol - 1;
				}
			}
			if (flag == 1)
				break;
		}
		if (flag == 0)
			System.out.println("Number not found");
	}
}
