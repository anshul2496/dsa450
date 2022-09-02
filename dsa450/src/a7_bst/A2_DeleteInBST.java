package a7_bst;

/*
 * https://leetcode.com/problems/delete-node-in-a-bst/
 *  			5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A2_DeleteInBST {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		preOrder(root);
		root = deleteFromBST(root, 3);
		System.out.println();
		preOrder(root);
	}

	private static Node deleteFromBST(Node root, int key) {
		if (root == null)
			return null;
		if (key < root.data)
			root.left = deleteFromBST(root.left, key);
		else if (key > root.data)
			root.right = deleteFromBST(root.right, key);
		else {
			if (root.left != null && root.right != null) {
				int lmax = getMax(root.left);
				root.data = lmax;
				root.left = deleteFromBST(root.left, lmax);
				return root;
			} else if (root.left != null) {
				return root.left;
			} else if (root.right != null) {
				return root.right;
			} else {
				return null;
			}
		}
		return root;
	}

	private static int getMax(Node node) {
		if (node.right != null)
			return getMax(node.right);
		else
			return node.data;
	}

	private static void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
