package b3_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * Recursive - https://www.youtube.com/watch?v=Qzf1a--rhp8
 * https://www.youtube.com/watch?v=iUtmQ66IC_0
 * remove mark* work add*
 * Same as BFS, just use stack instead of Queue
 */
public class A2_Dfs {
	public static void main(String[] args) {

	}

	// Iterative
	public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int n = adj.size();
		boolean[] visited = new boolean[n];
		st.push(0);
		while (!st.isEmpty()) {
			int top = st.pop();
			if (visited[top] == true)
				continue;
			visited[top] = true;
			ans.add(top);
			ArrayList<Integer> edges = adj.get(top);
			for (int e : edges) {
				if (visited[e] == false)
					st.push(e);
			}
		}
		return ans;
	}

	// Recursive function for DFS traversal
	static void DFSRec(List<List<Integer>> adj, boolean[] visited, int s) {
		visited[s] = true;
		System.out.print(s + " ");
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				DFSRec(adj, visited, i);
			}
		}
	}

	// Main DFS function that initializes the visited array
	static void DFS(List<List<Integer>> adj, int s) {
		boolean[] visited = new boolean[adj.size()];
		DFSRec(adj, visited, s);
	}
}
