package b3_graphs;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/rat-in-a-maze-problem/1
 * https://www.youtube.com/watch?v=wjqSZy4pMT4
 */
public class A5_RatInAMaze {
	public static void main(String[] args) {
		int[][] mat={{1, 0, 0, 0},
	                {1, 1, 0, 1}, 
	                {0, 1, 0, 0},
	                {0, 1, 1, 1}};
		System.out.println(findPath(mat));
		//Correct code but not passing in gfg
	}

	public static ArrayList<String> findPath(int[][] mat) {
		ArrayList<String> ans = new ArrayList<>();
		if (mat[0][0] == 0)
			return ans;
		int n = mat.length;
		boolean[][] vis = new boolean[n][n];
		solve(0, 0, n, vis, mat, ans, "");
		return ans;
	}

	public static void solve(int i, int j, int n, boolean[][] vis, int[][] mat, ArrayList<String> ans, String psf) {
		if (i == (n - 1) && j == (n - 1)) {
			ans.add(psf);
			return;
		}
		vis[i][j] = true;
		// Lexicographical order - D,L,R,U
		// Down
		if (isSafe(i + 1, j, n, vis, mat)) {
			solve(i + 1, j, n, vis, mat, ans, psf + 'D');
		}

		// Left
		if (isSafe(i, j - 1, n, vis, mat)) {
			solve(i, j - 1, n, vis, mat, ans, psf + 'L');
		}

		// Right
		if (isSafe(i, j + 1, n, vis, mat)) {
			solve(i, j + 1, n, vis, mat, ans, psf + 'R');
		}

		// Up
		if (isSafe(i - 1, j, n, vis, mat)) {
			solve(i - 1, j, n, vis, mat, ans, psf + 'U');
		}
		vis[i][j] = false;
	}

	public static boolean isSafe(int i, int j, int n, boolean[][] vis, int[][] mat) {
		if (i < 0 || i >= n || j < 0 || j >= n)
			return false;
		else if (vis[i][j] == true)
			return false;
		else if (mat[i][j] == 0)
			return false;
		else
			return true;
	}
}
