package b3_graphs;

import java.util.ArrayDeque;

/*
 * https://www.geeksforgeeks.org/problems/steps-by-knight5927/1
 * https://www.youtube.com/watch?v=HtIE-8QMUi0
 */
public class A6_StepsByKnight {
	public static void main(String[] args) {

	}

	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		int[] drow = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dcol = { 1, 2, 2, 1, -1, -2, -2, -1 };
		int row = KnightPos[1] - 1;
		int col = KnightPos[0] - 1;
		int targetRow = TargetPos[1] - 1;
		int targetCol = TargetPos[0] - 1;
		boolean[][] visited = new boolean[n][n];
		q.add(new Pair(row, col, 0));
		while (!q.isEmpty()) {
			Pair p = q.remove();
			if (p.row == targetRow && p.col == targetCol)
				return p.dis;
			for (int i = 0; i <= 7; i++) {
				int newRow = p.row + drow[i];
				int newCol = p.col + dcol[i];
				if (isSafe(newRow, newCol, n) && !visited[newRow][newCol]) {
					visited[newRow][newCol] = true;
					q.add(new Pair(newRow, newCol, p.dis + 1));
				}
			}
		}
		return -1;
	}

	public boolean isSafe(int r, int c, int n) {
		if (r < 0 || r >= n || c < 0 || c >= n)
			return false;
		return true;
	}
}

class Pair {
	int row;
	int col;
	int dis;

	public Pair(int row, int col, int dis) {
		this.row = row;
		this.col = col;
		this.dis = dis;
	}
}
