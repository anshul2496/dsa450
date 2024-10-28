package b3_graphs;

/*
 * https://leetcode.com/problems/flood-fill/description/
 * https://www.youtube.com/watch?v=C-2_uSRli8o
 */
public class A7_FloodFill {
	public static void main(String[] args) {

	}

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		int[][] ans = image;
		int initialColor = image[sr][sc];
		int[] dr = { 1, 0, 0, -1 };
		int[] dc = { 0, -1, 1, 0 };
		dfs(image, sr, sc, color, ans, initialColor, dr, dc);
		return ans;
	}

	public void dfs(int[][] image, int sr, int sc, int color, int[][] ans, int initialColor, int[] dr, int[] dc) {
		ans[sr][sc] = color;
		int n = image.length;
		int m = image[0].length;
		for (int i = 0; i < 4; i++) {
			int nrow = sr + dr[i];
			int ncol = sc + dc[i];
			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
					&& ans[nrow][ncol] != color) {
				dfs(image, nrow, ncol, color, ans, initialColor, dr, dc);
			}
		}
	}
}
