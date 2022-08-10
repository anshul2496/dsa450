package a3_string;

/*
 * https://www.geeksforgeeks.org/find-count-number-given-string-present-2d-character-array/
 * 
 */
public class C2_CountStringIn2DArray {
	public static void main(String[] args) {
		char[][] board = { { 'B', 'B', 'M', 'B', 'B', 'B' }, { 'C', 'B', 'A', 'B', 'B', 'B' },
				{ 'I', 'B', 'G', 'B', 'B', 'B' }, { 'G', 'B', 'I', 'B', 'B', 'B' }, { 'A', 'B', 'C', 'B', 'B', 'B' },
				{ 'M', 'C', 'I', 'G', 'A', 'M' } };
		String word = "MAGIC";
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (word.charAt(0) == board[i][j] && explore(board, i, j, 0, word)) {
					System.out.println("Pattern found at " + i + "," + j);
					count++;
				}
			}
		}
		System.out.println(count);
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
		boolean found = explore(board, i + 1, j, charIndex + 1, word) // Vertically Up
				|| explore(board, i - 1, j, charIndex + 1, word) // Vertically Down
				|| explore(board, i, j + 1, charIndex + 1, word) // Horizontally right
				|| explore(board, i, j - 1, charIndex + 1, word); // Horizontally left
		board[i][j] = temp;
		return found;
	}
}
