package interviews;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1
 * Soln -> https://www.youtube.com/watch?v=U5Mw4eyUmw4
 */
public class B8_ShortestPathBinaryMaze {
	public static void main(String[] args) {

	}

	int shortestPath(int[][] grid, int[] source, int[] destination) {
		if (source[0] == destination[0] && source[1] == destination[1])
			return 0;
		int row = grid.length;
		int col = grid[0].length;
		int[][] distance = new int[row][col];
		Queue<TriEle> q = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				distance[i][j] = (int) (1e9);
			}
		}
		distance[source[0]][source[1]] = 0;
		q.add(new TriEle(0, source[0], source[1]));
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, 1, -1 };
		while (!q.isEmpty()) {
			TriEle tri = q.peek();
			q.remove();
			int dis = tri.first;
			int sr = tri.second;
			int sc = tri.third;
			for (int i = 0; i < 4; i++) {
				int nr = sr + dr[i];
				int nc = sc + dc[i];
				if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1 
						&& distance[nr][nc] > dis + 1) {
					distance[nr][nc] = dis + 1;
					if (nr == destination[0] && nc == destination[1]) {
						return dis + 1;
					}
					q.add(new TriEle(dis + 1, nr, nc));
				}
			}
		}
		return -1;
	}
}

class TriEle {
	int first;
	int second;
	int third;

	public TriEle(int first, int second, int third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
}
