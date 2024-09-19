package a9_backtracking;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/n-queen-problem0315/1
 * https://www.youtube.com/watch?v=yvt0emtFiIE
 */
public class A2_N_Queen {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> ans = nQueen(4);
		System.out.println(ans);
	}

	public static ArrayList<ArrayList<Integer>> nQueen(int n) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		boolean[][] board = new boolean[n][n];
		boolean[] col = new boolean[n];
		boolean[] ndiag = new boolean[(2 * n) - 1];
		boolean[] rdiag = new boolean[(2 * n) - 1];
		solve(board, 0, col, ndiag, rdiag, ans, n, "");
		return ans;
	}

	public static void solve(boolean[][] board, int row, boolean[] col, boolean[] ndiag, boolean[] rdiag,
			ArrayList<ArrayList<Integer>> ans, int n, String asf) {
		if (row == n) {
			ArrayList<Integer> temp = new ArrayList<>();
			String[] arr = asf.split(",");
			for (String val : arr) {
				if (!val.equals(""))
					temp.add(Integer.parseInt(val));
			}
			ans.add(temp);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (col[i] == false && ndiag[row + i] == false && rdiag[row - i + n - 1] == false) {
				board[row][i] = true;
				col[i] = true;
				ndiag[row + i] = true;
				rdiag[row - i + n - 1] = true;
				solve(board, row + 1, col, ndiag, rdiag, ans, n, asf + "" + (i + 1) + ",");
				board[row][i] = false;
				col[i] = false;
				ndiag[row + i] = false;
				rdiag[row - i + n - 1] = false;
			}
		}
	}
}
