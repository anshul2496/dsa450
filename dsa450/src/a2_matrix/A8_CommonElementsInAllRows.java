package a2_matrix;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/common-elements-in-all-rows-of-a-given-matrix/
 * Given an m x n matrix, find all common elements present in all rows in O(mn) time and one traversal of matrix.
	Example: 
	Input:
	mat[4][5] = {{1, 2, 1, 4, 8},
	             {3, 7, 8, 5, 1},
	             {8, 7, 7, 3, 1},
	             {8, 1, 2, 7, 9},
	            };
	Output: 
	1 8 or 8 1
	8 and 1 are present in all rows.
 */
public class A8_CommonElementsInAllRows {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 1, 4, 8 }, { 3, 7, 8, 5, 1 }, { 8, 7, 7, 3, 1 }, { 8, 1, 2, 7, 9 } };
		int rows = a.length;
		int cols = a[0].length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cols; i++) {
			map.put(a[0][i], 1);
		}
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				// If element is present in the map and not duplicated in the current row
				if (map.get(a[i][j]) != null && map.get(a[i][j]) == i) {
					map.put(a[i][j], i + 1);

					// If this is the last row
					if (i == rows - 1) {
						System.out.print(a[i][j] + " ");
					}
				}
			}
		}
	}
}
