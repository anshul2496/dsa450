package interviews;

import java.util.ArrayList;

/*
 * https://practice.geeksforgeeks.org/problems/burning-tree/1
 * https://www.youtube.com/watch?v=dtBj2A_7JOk - Not this method
 * The below solved method is derived from prev problem(It is wrong)
 *  		12
           /  \
          13  10
              / \
             14 15
            / \ / \
          21 24 22 23
 */
public class B2_BurningTree {
	private static int maxTime = 0;

	public static void main(String[] args) {
		B1_Node root = new B1_Node(12);
		root.left = new B1_Node(13);
		root.right = new B1_Node(10);
		root.right.left = new B1_Node(14);
		root.right.right = new B1_Node(15);
		B1_Node left = root.right.left;
		B1_Node right = root.right.right;
		left.left = new B1_Node(21);
		left.right = new B1_Node(24);
		right.left = new B1_Node(22);
		right.right = new B1_Node(23);
		right.right.right = new B1_Node(27);

		B1_Node fireNode = new B1_Node(10);
		burningTree(root, fireNode);
		System.out.println(maxTime);
	}

	private static void burningTree(B1_Node root, B1_Node fireNode) {
		ArrayList<B1_Node> path = new ArrayList<>();
		getRootToNodePath(root, fireNode, path);
		for (int i = 0; i < path.size(); i++) {
			burnSubTree(path.get(i), i, i == 0 ? null : path.get(i - 1));
		}
	}

	private static void burnSubTree(B1_Node node, int time, B1_Node blocked) {
		if (node == null || blocked == null || node.data == blocked.data) {
			return;
		}
		maxTime = Math.max(time, maxTime);
		burnSubTree(node.left, time + 1, blocked);
		burnSubTree(node.right, time + 1, blocked);
	}

	private static boolean getRootToNodePath(B1_Node root, B1_Node fireNode, ArrayList<B1_Node> path) {
		if (root == null)
			return false;
		if (root.data == fireNode.data) {
			path.add(root);
			return true;
		}
		boolean left = getRootToNodePath(root.left, fireNode, path);
		if (left) {
			path.add(root);
			return true;
		}
		boolean right = getRootToNodePath(root.right, fireNode, path);
		if (right) {
			path.add(root);
			return true;
		}
		return false;
	}
}
