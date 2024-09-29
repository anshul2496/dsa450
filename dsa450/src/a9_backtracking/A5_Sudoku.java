package a9_backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
 * https://www.youtube.com/watch?v=uyetDh-DyDg
 */
public class A5_Sudoku {
	public static void main(String[] args) {
		int[][] grid = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 }, 
						{ 5, 2, 0, 0, 0, 0, 0, 0, 0 }, 
						{ 0, 8, 7, 0, 0, 0, 0, 3, 1, },
						{ 0, 0, 3, 0, 1, 0, 0, 8, 0 }, 
						{ 9, 0, 0, 8, 6, 3, 0, 0, 5 }, 
						{ 0, 5, 0, 0, 9, 0, 6, 0, 0 },
						{ 1, 3, 0, 0, 0, 0, 2, 5, 0 }, 
						{ 0, 0, 0, 0, 0, 0, 0, 7, 4 }, 
						{ 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		System.out.println(SolveSudoku(grid));
		printGrid(grid);
	}

	static boolean SolveSudoku(int grid[][]) {
		List<Boolean> list=new ArrayList<>();
		list.add(0, false);
		solve(grid, 0, 0,list);
		return list.get(0);
	}

	static void solve(int[][] board, int i, int j,List<Boolean> list) {
		if (i == board.length) {
			//printGrid(board);
			list.set(0, true);
			return;
		}
		int ni = 0;
		int nj = 0;
		if (j == board[0].length - 1) {
			ni = i + 1;
			nj = 0;
		} else {
			ni = i;
			nj = j + 1;
		}
		if (board[i][j] != 0) {
			solve(board, ni, nj,list);
		} else {
			for (int po = 1; po <= 9; po++) {
				if (isValid(board, i, j, po)) {
					board[i][j] = po;
					solve(board, ni, nj,list);
					if(list.get(0)==false) board[i][j]=0;
				}
			}
		}
	}

	static boolean isValid(int[][] board, int x, int y, int po) {
		for (int i = 0; i < board[0].length; i++) {
			if (board[x][i] == po)
				return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] == po)
				return false;
		}
		int r = (x / 3) * 3;
		int c = (y / 3) * 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[r + i][c + j] == po)
					return false;
			}
		}
		return true;
	}

	// Function to print grids of the Sudoku.
	static void printGrid(int grid[][]) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
		}
	}
}
