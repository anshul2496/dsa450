package b3_graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/number-of-islands/submissions/1801136138/
 * https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * https://www.youtube.com/watch?v=muncqlKJrH0
 */
class Pair5 {
	int first;
	int second;

	public Pair5(int first, int second) {
		this.first = first;
		this.second = second;
	}
}
//Time and Space Complexity - N*M
public class B3_NumberOfIslands {
	public static void main(String[] args) {
		char[][] grid = { { '0', '1', '1', '1', '0', '0', '0' }, 
						  { '0', '0', '1', '1', '0', '1', '0' } };
		B3_NumberOfIslands obj = new B3_NumberOfIslands();
		System.out.println(obj.numIslands(grid));
	}

	private void bfs(int ro, int co, int[][] vis, char[][] grid) {
		vis[ro][co] = 1;
		Queue<Pair5> q = new LinkedList<Pair5>();
		q.add(new Pair5(ro, co));
		int n = grid.length;
		int m = grid[0].length;

		// until the queue becomes empty
		while (!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();

			// traverse in the neighbours and mark them if its a land
			for (int delrow = -1; delrow <= 1; delrow++) {
				for (int delcol = -1; delcol <= 1; delcol++) {
					int nrow = row + delrow;
					int ncol = col + delcol;
					// check if neighbour row and column is valid, and is an unvisited land
					if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1'
							&& vis[nrow][ncol] == 0) {
						vis[nrow][ncol] = 1;
						q.add(new Pair5(nrow, ncol));
					}
				}
			}
		}
	}

	// Function to find the number of islands.
	public int numIslands(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] vis = new int[n][m];
		int cnt = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				// if not visited and is a land
				if (vis[row][col] == 0 && grid[row][col] == '1') {
					cnt++;
					bfs(row, col, vis, grid);
				}
			}
		}
		return cnt;
	}
}
