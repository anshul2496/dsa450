package b3_graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
 * https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
 * https://www.youtube.com/watch?v=BPlrALf1LDU
 */
class Pair3 {
	int first;
	int second;

	Pair3(int first, int second) {
		this.first = first;
		this.second = second;
	}
}

public class A3_CycleUndirectedGraph {
	public static void main(String[] args) {
		int v = 4;
		int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 2, 3 } };
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 0; i < v; i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		System.out.println(adj);
		System.out.println(isCycle(adj));
	}

	// Summation of adj nodes = Summation of degress = 2E
	// TC - O(N+2E)
	// SC - O(N)
	public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
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

	public static boolean isCycleBFS(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
		visited[src] = true;
		Queue<Pair3> q = new LinkedList<>();
		q.add(new Pair3(src, -1));
		while (!q.isEmpty()) {
			int node = q.peek().first;
			int parent = q.peek().second;
			q.remove();
			for (int adjNode : adj.get(node)) {
				if (visited[adjNode] == false) {
					visited[adjNode] = true;
					q.add(new Pair3(adjNode, node));
				} else if (parent != adjNode) {
					return true;
				}
			}
		}
		return false;
	}
}
