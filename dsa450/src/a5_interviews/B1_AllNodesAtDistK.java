package a5_interviews;

import java.util.ArrayList;

/*
 * https://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
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
	If target is 14 and k is 3, then output 
	should be “4 20”
 */
public class B1_AllNodesAtDistK {
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
		ArrayList<Integer> ans = new ArrayList<>();
		distanceK(root, target, k, ans);
		System.out.println(ans);
	}

	private static int distanceK(B1_Node root, int target, int k, ArrayList<Integer> ans) {
		if (root == null)
			return -1;

		if (root.data == target) {
			kdown(root, k - 0, null, ans);
			return 1;
		}

		int ld = distanceK(root.left, target, k, ans);
		if (ld != -1) {
			kdown(root, k - ld, root.left, ans);
			return ld + 1;
		}

		int rd = distanceK(root.right, target, k, ans);
		if (rd != -1) {
			kdown(root, k - rd, root.right, ans);
			return rd + 1;
		}
		return -1;
	}

	private static void kdown(B1_Node root, int k, B1_Node blockNode, ArrayList<Integer> ans) {
		if (root == null || k < 0 || root == blockNode) {
			return;
		}
		if (k == 0) {
			ans.add(root.data);
			return;
		}
		kdown(root.left, k - 1, blockNode, ans);
		kdown(root.right, k - 1, blockNode, ans);
	}
}

class B1_Node {
	int data;
	B1_Node left, right;

	public B1_Node(int data) {
		this.data = data;
	}
}