package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/check-for-bst/1
 *  *  			5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A5_IsBST {
	static Node prev = null;

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		boolean isBST = isBST(root);
		System.out.println(isBST);
	}

	private static boolean isBST(Node root) {
		if (root == null)
			return true;
		if (!isBST(root.left))
			return false;
		if (prev != null && prev.data > root.data)
			return false;
		prev = root;
		if (!isBST(root.right))
			return false;
		return true;
	}
}
