package b3_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
 * https://www.youtube.com/watch?v=iUtmQ66IC_0
 */
public class A2_Dfs {
	public static void main(String[] args) {

	}

	// Iterative
	public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> ans = new ArrayList<>();
		Stack<Integer> st = new Stack<>();
		int n = adj.size();
		boolean[] checked = new boolean[n];
		st.push(0);
		while (!st.isEmpty()) {
			int top = st.pop();
			if (checked[top] == true)
				continue;
			checked[top] = true;
			ans.add(top);
			ArrayList<Integer> edges = adj.get(top);
			for (int e : edges) {
				if (checked[e] == false)
					st.push(e);
			}
		}
		return ans;
	}

	// Recursive function for DFS traversal
	static void DFSRec(List<List<Integer>> adj, boolean[] visited, int s) {
		// Mark the current vertex as visited
		visited[s] = true;

		// Print the current vertex
		System.out.print(s + " ");

		// Recursively visit all adjacent vertices that are
		// not visited yet
		for (int i : adj.get(s)) {
			if (!visited[i]) {
				DFSRec(adj, visited, i);
			}
		}
	}

	// Main DFS function that initializes the visited array
	static void DFS(List<List<Integer>> adj, int s) {
		boolean[] visited = new boolean[adj.size()];
		// Call the recursive DFS function
		DFSRec(adj, visited, s);
	}
}
