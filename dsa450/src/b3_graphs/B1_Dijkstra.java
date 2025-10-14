package b3_graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
 * https://www.youtube.com/watch?v=V6H1qAeB-l4
 */
public class B1_Dijkstra {

}

// Tc - ELogV
class Solution {
	// Function to find the shortest distance of all the vertices
	// from the source vertex src.
	ArrayList<Integer> dijkstra(ArrayList<ArrayList<iPair>> adj, int src) {
		ArrayList<Integer> dist = new ArrayList<>();
		//TC - O(ElogV)
		PriorityQueue<B1_Pair> pq = new PriorityQueue<B1_Pair>((x, y) -> x.distance - y.distance);
		for (int i = 0; i < adj.size(); i++) {
			if (src == i) {
				dist.add(i, 0);
			} else {
				dist.add(i, Integer.MAX_VALUE);
			}
		}
		pq.add(new B1_Pair(0, src));
		while (!pq.isEmpty()) {
			int distance = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();

			for (int i = 0; i < adj.get(node).size(); i++) {
				int edgeWeight = adj.get(node).get(i).second;
				int adjNode = adj.get(node).get(i).first;
				if (distance + edgeWeight < dist.get(adjNode)) {
					dist.set(adjNode, distance + edgeWeight);
					pq.add(new B1_Pair(dist.get(adjNode), adjNode));
				}
			}
		}
		return dist;
	}
}

class B1_Pair {
	int distance;
	int node;

	public B1_Pair(int distance, int node) {
		this.distance = distance;
		this.node = node;
	}
}
class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}