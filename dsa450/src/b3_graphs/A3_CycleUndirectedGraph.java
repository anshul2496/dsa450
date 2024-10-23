package b3_graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * https://www.youtube.com/watch?v=1cSzxlhxOw8
 */
public class A3_CycleUndirectedGraph {
	public static void main(String[] args) {

	}

	public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (isCycleBFS(i, visited, adj))
					return true;
			}
		}
		return false;
	}

	public boolean isCycleBFS(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		int n = adj.size();
		int[] parent = new int[n];
		parent[src] = -1;
		visited[src] = true;
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.add(src);
		while (!q.isEmpty()) {
			int top = q.removeFirst();
			ArrayList<Integer> edges = adj.get(top);
			for (int e : edges) {
				if (visited[e] == true && e != parent[top])
					return true;
				else if (!visited[e]) {
					visited[e] = true;
					parent[e] = top;
					q.push(e);
				}
			}
		}
		return false;
	}
}
