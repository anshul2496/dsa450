package b3_graphs;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/flood-fill/description/
 * https://www.youtube.com/watch?v=C-2_uSRli8o
 */
public class A7_FloodFill {
	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1;
		int sc = 1;
		int color = 2;
		int[][] ans = floodFill(image, sr, sc, color);
		for (int i = 0; i < image.length; i++) {
			for (int j = 0; j < image[0].length; j++) {
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}

	// My soln. using BFS
	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] ans=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans[i][j]=image[i][j];
            }
        }
        boolean[][] vis=new boolean[m][n];
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        Queue<PairA7> q=new LinkedList<>();
        q.add(new PairA7(sr,sc));
        vis[sr][sc]=true;
        int temp=image[sr][sc];
        while(!q.isEmpty()){
            int r=q.peek().first;
            int c=q.peek().second;
            q.remove();
            ans[r][c]=color;
            vis[r][c]=true;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<m && nc>=0 && nc<n && image[nr][nc]==temp && !vis[nr][nc]){
                    q.add(new PairA7(nr,nc));
                }
            }
        }
        return ans;
    }
	
	// Video soln using DFS
//	public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
//		int[][] ans = image;
//		int initialColor = image[sr][sc];
//		int[] dr = { 1, 0, 0, -1 };
//		int[] dc = { 0, -1, 1, 0 };
//		dfs(image, sr, sc, color, ans, initialColor, dr, dc);
//		return ans;
//	}
//
//	public static void dfs(int[][] image, int sr, int sc, int color, int[][] ans, int initialColor, int[] dr,
//			int[] dc) {
//		ans[sr][sc] = color;
//		int n = image.length;
//		int m = image[0].length;
//		for (int i = 0; i < 4; i++) {
//			int nrow = sr + dr[i];
//			int ncol = sc + dc[i];
//			if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == initialColor
//					&& ans[nrow][ncol] != color) {
//				dfs(image, nrow, ncol, color, ans, initialColor, dr, dc);
//			}
//		}
//	}
}
class PairA7{
    int first;
    int second;
    public PairA7(int first,int second){
        this.first=first;
        this.second=second;
    }
}
