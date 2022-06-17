package a5_interviews;

import java.util.ArrayList;

/*
 * https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1/
 * https://www.youtube.com/watch?v=B89In5BctFA // This one
 * https://www.youtube.com/watch?v=s22QClql9LU
 * Given a binary tree, a target node in the binary tree, and an integer value k, print all the nodes that are at distance k from the given target node.
 *      20
 *    8   22
 *  4  12
 *    10  14
 *    
 *  Consider the tree shown in diagram Input: target = pointer to node with data 8. 
	root = pointer to node with data 20. 
	k = 2. 
	Output : 10 14 22
	If target is 14 and k is 3, then output should be “4 20”
 */
public class B12_AllNodesAtDistK {

	public static void main(String[] args) {
		B1_Node root = new B1_Node(20);
		root.left = new B1_Node(8);
		root.right = new B1_Node(22);
		root.left.left = new B1_Node(4);
		root.left.right = new B1_Node(12);
		root.left.right.left = new B1_Node(10);
		root.left.right.right = new B1_Node(14);
		int target = 8;
		printkdistanceNode(root, target, 2);
	}

	private static void printkdistanceNode(B1_Node root, int target, int k) {
		ArrayList<B1_Node> path = new ArrayList<>();
		getRootToNodePath(root, target, path);
		for (int i = 0; i < path.size(); i++) {
			printKLevelsDown(path.get(i), k - i, i == 0 ? null : path.get(i - 1));
		}
	}

	private static void printKLevelsDown(B1_Node node, int k, B1_Node blocked) {
		if (node == null || k < 0 || node == blocked) {
			return;
		}
		if (k == 0) {
			System.out.print(node.data + " ");
		}
		printKLevelsDown(node.left, k - 1, blocked);
		printKLevelsDown(node.right, k - 1, blocked);
	}

	private static boolean getRootToNodePath(B1_Node root, int target, ArrayList<B1_Node> path) {
		if (root == null) {
			return false;
		}
		if (root.data == target) {
			path.add(root);
			return true;
		}
		boolean left = getRootToNodePath(root.left, target, path);
		if (left) {
			path.add(root);
			return true;
		}
		boolean right = getRootToNodePath(root.right, target, path);
		if (right) {
			path.add(root);
			return true;
		}
		return false;
	}
}

class B1_Node {
	int data;
	B1_Node left, right;

	public B1_Node(int data) {
		this.data = data;
	}
}