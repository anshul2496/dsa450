package b3_graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/rotting-oranges/description/
 * https://www.youtube.com/watch?v=yf3oUhkvqA0
 */
class Pair4 {
	int row;
	int col;
	int tm;

	Pair4(int _row, int _col, int _tm) {
		this.row = _row;
		this.col = _col;
		this.tm = _tm;
	}
}
// Time and Space Complexity - N*M
public class B2_RottingOranges {
	public int orangesRotting(int[][] grid) {
		// figure out the grid size
		int n = grid.length;
		int m = grid[0].length;
		// n x m
		Queue<Pair4> q = new LinkedList<>();
		// n x m
		int[][] vis = new int[n][m];
		int cntFresh = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// if cell contains rotten orange
				if (grid[i][j] == 2) {
					q.add(new Pair4(i, j, 0));
					// mark as visited (rotten) in visited array
					vis[i][j] = 2;
				}
				// if not rotten
				else {
					vis[i][j] = 0;
				}

				// count fresh oranges
				if (grid[i][j] == 1)
					cntFresh++;
			}
		}

		int tm = 0;
		// delta row and delta column
		int drow[] = { -1, 0, +1, 0 };
		int dcol[] = { 0, 1, 0, -1 };
		int cnt = 0;

		// until the queue becomes empty
		while (!q.isEmpty()) {
			int r = q.peek().row;
			int c = q.peek().col;
			int t = q.peek().tm;
			tm = Math.max(tm, t);
			q.remove();
			// exactly 4 neighbours
			for (int i = 0; i < 4; i++) {
				int nrow = r + drow[i];
				int ncol = c + dcol[i];
				// check for valid coordinates and
				// then for unvisited fresh orange
				if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
						&& vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
					// push in queue with timer increased
					q.add(new Pair4(nrow, ncol, t + 1));
					// mark as rotten
					vis[nrow][ncol] = 2;
					cnt++;
				}
			}
		}

		// if all oranges are not rotten
		if (cnt != cntFresh)
			return -1;
		return tm;
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 1, 2 }, { 0, 1, 2 }, { 2, 1, 1 } };

		B2_RottingOranges obj = new B2_RottingOranges();
		int ans = obj.orangesRotting(grid);
		System.out.println(ans);
	}
}
