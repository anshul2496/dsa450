package a9_backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * https://www.geeksforgeeks.org/problems/m-coloring-problem-1587115620/1
 * https://www.youtube.com/watch?v=AOKXa_-mmTE
 */
public class A6_M_Coloring {
	public static void main(String[] args) {
		
	}

	public static boolean graphColoring(boolean graph[][], int m, int n) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
			for (int j = 0; j < n; j++) {
				if (graph[i][j]) {
					map.get(i).add(j);
				}
			}
		}
		int[] col = new int[n];
		return dfs(map, 0, col, m, n);
	}

	public static boolean dfs(Map<Integer, ArrayList<Integer>> map, int currNode, int[] col, int m, int n) {
		if (currNode == n)
			return true;
		for (int color = 1; color <= m; color++) {
			if (isSafe(map, currNode, col, m, n, color)) {
				col[currNode] = color;
				if (dfs(map, currNode + 1, col, m, n))
					return true;
				col[currNode] = 0;
			}
		}
		return false;
	}

	public static boolean isSafe(Map<Integer, ArrayList<Integer>> map, int currNode, int[] col, int m, int n, int color) {
		ArrayList<Integer> list = map.get(currNode);
		for (int neb : list) {
			if (col[neb] == color)
				return false;
		}
		return true;
	}
}
