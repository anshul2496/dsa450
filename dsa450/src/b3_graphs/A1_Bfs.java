package b3_graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
 * https://www.youtube.com/watch?v=GHnC5qHexsk
 */
public class A1_Bfs {
	public static void main(String[] args) {

	}

	public ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		int n = adj.size();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		boolean[] visit = new boolean[n];
		q.add(0);
		while (!q.isEmpty()) {
			int rem = q.removeFirst();
			if (visit[rem] == true)
				continue;
			visit[rem] = true;
			ans.add(rem);
			ArrayList<Integer> edges = adj.get(rem);
			for (int e : edges) {
				if (visit[e] == false) {
					q.add(e);
				}
			}
		}
		return ans;
	}
}
