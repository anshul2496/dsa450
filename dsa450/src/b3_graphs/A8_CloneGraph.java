package b3_graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * https://leetcode.com/problems/clone-graph/
 * https://www.youtube.com/watch?v=Nki9V1tD5_I
 */
public class A8_CloneGraph {
	public static void main(String[] args) {

	}

	public Node cloneGraph(Node node) {
		if (node == null)
			return node;
		HashMap<Node, Node> map = new HashMap<>();
		return cloneUtil(node, map);
	}

	public Node cloneUtil(Node node, HashMap<Node, Node> map) {
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		for (Node neighbor : node.neighbors) {
			if (!map.containsKey(neighbor)) {
				// it is not cloned
				newNode.neighbors.add(cloneUtil(neighbor, map));
			} else {
				newNode.neighbors.add(map.get(neighbor));
			}
		}
		return newNode;
	}
}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
