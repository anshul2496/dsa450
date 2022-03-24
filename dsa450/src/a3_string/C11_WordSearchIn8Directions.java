package a3_string;

import java.util.Arrays;

/*
 * https://www.geeksforgeeks.org/search-a-word-in-a-2d-grid-of-characters/
 * Given a 2D grid of characters and a word, find all occurrences of the given word in the grid. 
 * A word can be matched in all 8 directions at any point. Word is said to be found in a direction 
 * if all characters match in this direction (not in zig-zag form).
	The 8 directions are, Horizontally Left, Horizontally Right, Vertically Up, Vertically Down and 4 Diagonal directions.
	Example: 
	Input:  grid[][] = {"GEEKSFORGEEKS",
	                    "GEEKSQUIZGEEK",
	                    "IDEQAPRACTICE"};
	        word = "GEEKS"
	Output: pattern found at 0, 0
	        pattern found at 0, 8
	        pattern found at 1, 0
	Explanation: 'GEEKS' can be found as prefix of 1st 2 rows and suffix of first row
 */
public class C11_WordSearchIn8Directions {
	public static void main(String[] args) {
		char[][] board = { { 'G', 'E', 'E', 'K', 'S', 'F', 'O', 'R', 'G', 'E', 'E', 'K', 'S' },
						   { 'G', 'E', 'E', 'K', 'S', 'Q', 'U', 'I', 'Z', 'G', 'E', 'E', 'K' },
						   { 'I', 'D', 'E', 'Q', 'A', 'P', 'R', 'A', 'C', 'T', 'I', 'C', 'E' } };
		String word = "EE";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && explore(board, i, j, 0, word)) {
					System.out.println("Pattern found at " + i + "," + j);
				}
			}
		}

	}

	private static boolean explore(char[][] board, int i, int j, int charIndex, String word) {
		if (charIndex == word.length()) {
			return true;
		}
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(charIndex) != board[i][j]) {
			return false;
		}
		char temp = board[i][j];
		board[i][j] = '*';
//		System.out.println();
//		for (int x = 0; x < board.length; x++) {
//			for (int y = 0; y < board[0].length; y++) {
//				System.out.print(board[x][y] + " ");
//			}
//			System.out.println();
//		}
		boolean found = explore(board, i + 1, j, charIndex + 1, word) // Vertically Up
				|| explore(board, i - 1, j, charIndex + 1, word) // Vertically Down
				|| explore(board, i, j + 1, charIndex + 1, word) // Horizontally right
				|| explore(board, i, j - 1, charIndex + 1, word) // Horizontally left
				|| explore(board, i - 1, j + 1, charIndex + 1, word) // Up Diagonal right
				|| explore(board, i - 1, j - 1, charIndex + 1, word) // Up Diagonal left
				|| explore(board, i + 1, j + 1, charIndex + 1, word) // Down diagonal right
				|| explore(board, i + 1, j - 1, charIndex + 1, word); // Down diagonal left
		board[i][j] = temp;
		return found;
	}
}
