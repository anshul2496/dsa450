package a3_string;

/*
 * https://www.youtube.com/watch?v=vYYNp0Jrdv0
 * https://leetcode.com/problems/word-search/
 * 	Given an m x n grid of characters board and a string word, return true if word exists in the grid.
	The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. 
	The same letter cell may not be used more than once.
	Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
	Output: true
 */
public class C1_WordSearch4Directions {
	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		boolean flag = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && explore(board, i, j, 0, word)) {
					// System.out.println("Pattern found at " + i + "," + j); // To find occurrences of the string you can print row,col and don't break;
					flag = true;
					break;
				}
			}
		}
		System.out.println(flag);
	}

	private static boolean explore(char[][] board, int i, int j, int charIndex, String word) {
		if (charIndex == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(charIndex)) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = '*';
		boolean found = explore(board, i + 1, j, charIndex + 1, word) || explore(board, i - 1, j, charIndex + 1, word)
				|| explore(board, i, j - 1, charIndex + 1, word) || explore(board, i, j + 1, charIndex + 1, word);
		board[i][j] = temp;
		return found;
	}
}
