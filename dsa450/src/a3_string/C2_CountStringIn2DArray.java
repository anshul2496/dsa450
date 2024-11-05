package a3_string;

/*
 * https://www.geeksforgeeks.org/problems/count-occurences-of-a-given-word-in-a-2-d-array/1
 */
public class C2_CountStringIn2DArray {
	public static void main(String[] args) {
		char[][] board = {  { 'B', 'B', 'M', 'B', 'B', 'B' }, 
							{ 'C', 'B', 'A', 'B', 'B', 'B' },
							{ 'I', 'B', 'G', 'B', 'B', 'B' }, 
							{ 'G', 'B', 'I', 'B', 'B', 'B' }, 
							{ 'A', 'B', 'C', 'B', 'B', 'B' },
							{ 'M', 'C', 'I', 'G', 'A', 'M' } };
		String word = "MAGIC";
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				count += solve(board, word, i, j, 0);
			}
		}
		System.out.println(count);
	}

	public static int solve(char mat[][], String target, int i, int j, int count) {
		int found = 0;
		if (i >= 0 && i < mat.length && j >= 0 && j < mat[0].length && mat[i][j] == target.charAt(count)) {
			char temp = mat[i][j];
			mat[i][j] = '*';
			if (count == target.length() - 1)
				found = 1;
			else {
				found += solve(mat, target, i + 1, j, count + 1);
				found += solve(mat, target, i - 1, j, count + 1);
				found += solve(mat, target, i, j + 1, count + 1);
				found += solve(mat, target, i, j - 1, count + 1);
			}
			mat[i][j] = temp;
		}
		return found;
	}
}
