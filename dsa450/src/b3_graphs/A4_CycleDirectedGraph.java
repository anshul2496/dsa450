package b3_graphs;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
 * https://www.youtube.com/watch?v=Tl5qbEmEQyY
 */
public class A4_CycleDirectedGraph {
	public static void main(String[] args) {
		int v = 4;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 3 } };
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < v; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
		}
		System.out.println(adj);
		System.out.println(isCyclic(v, adj));
	}

	public static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean[] visited = new boolean[v];
		boolean[] dfsVisited = new boolean[v];
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				if (isCyclicDFS(i, visited, dfsVisited, adj))
					return true;
			}
		}
		return false;
	}

	public static boolean isCyclicDFS(int src, boolean[] visited, boolean[] dfsVisited, ArrayList<ArrayList<Integer>> adj) {
		visited[src] = true;
		dfsVisited[src] = true;
		ArrayList<Integer> edges = adj.get(src);
		for (int e : edges) {
			if (!visited[e]) {
				if (isCyclicDFS(e, visited, dfsVisited, adj))
					return true;
			} else if (dfsVisited[e]) {
				return true;
			}
		}
		dfsVisited[src] = false;
		return false;
	}
}
