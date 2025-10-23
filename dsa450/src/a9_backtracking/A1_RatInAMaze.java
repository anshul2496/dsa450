package a9_backtracking;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * https://takeuforward.org/data-structure/rat-in-a-maze/
 * Same as Graph A5
 */
public class A1_RatInAMaze {
	public static void main(String[] args) {
		int[][] mat = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };
		ArrayList<String> ans = findPath(mat);
		System.out.println(ans);
	}

	public static ArrayList<String> findPath(int[][] mat) {
		ArrayList<String> ans = new ArrayList<>();
		int n = mat.length;
		int[][] vis = new int[n][n];
		if (mat[0][0] == 1)
			solve(0, 0, mat, vis, "", ans, n);
		return ans;
	}

	public static void solve(int i, int j, int[][] mat, int[][] vis, String move, ArrayList<String> ans, int n) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}
		// Down
		if (i + 1 < n && vis[i + 1][j] == 0 && mat[i + 1][j] == 1) {
			vis[i][j] = 1;
			solve(i + 1, j, mat, vis, move + "D", ans, n);
			vis[i][j] = 0;
		}

		// Left
		if (j - 1 >= 0 && vis[i][j - 1] == 0 && mat[i][j - 1] == 1) {
			vis[i][j] = 1;
			solve(i, j - 1, mat, vis, move + "L", ans, n);
			vis[i][j] = 0;
		}

		// Right
		if (j + 1 < n && vis[i][j + 1] == 0 && mat[i][j + 1] == 1) {
			vis[i][j] = 1;
			solve(i, j + 1, mat, vis, move + "R", ans, n);
			vis[i][j] = 0;
		}

		// Up
		if (i - 1 >= 0 && vis[i - 1][j] == 0 && mat[i - 1][j] == 1) {
			vis[i][j] = 1;
			solve(i - 1, j, mat, vis, move + "U", ans, n);
			vis[i][j] = 0;
		}
	}
}
