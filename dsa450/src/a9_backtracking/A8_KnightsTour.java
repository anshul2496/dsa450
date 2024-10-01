package a9_backtracking;

/*
 * https://www.geeksforgeeks.org/the-knights-tour-problem/
 * https://www.youtube.com/watch?v=SP880DBRJ_8
 */
public class A8_KnightsTour {
	public static void main(String[] args) {
		int n = 8;
		int r = 0;
		int c = 0;
		int[][] chess = new int[n][n];
		printKnightsTour(chess, r, c, 1);
	}

	private static void printKnightsTour(int[][] chess, int r, int c, int move) {
		if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
			return;
		else if (move == chess.length * chess.length) {
			chess[r][c] = move;
			displayBoard(chess);
			chess[r][c] = 0;
			return;
		}
		chess[r][c] = move;
		printKnightsTour(chess, r - 2, c + 1, move + 1);
		printKnightsTour(chess, r - 1, c + 2, move + 1);
		printKnightsTour(chess, r + 1, c + 2, move + 1);
		printKnightsTour(chess, r + 2, c + 1, move + 1);
		printKnightsTour(chess, r + 2, c - 1, move + 1);
		printKnightsTour(chess, r + 1, c - 2, move + 1);
		printKnightsTour(chess, r - 1, c - 2, move + 1);
		printKnightsTour(chess, r - 2, c - 1, move + 1);
		chess[r][c] = 0;
	}

	private static void displayBoard(int[][] chess) {
		for (int i = 0; i < chess.length; i++) {
			for (int j = 0; j < chess[0].length; j++) {
				System.out.print(chess[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("***************");
	}
}
