package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/minimum-element-in-bst/1
 * 				5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A3_MinInBST {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		int min = getMin(root);
		System.out.println(min);
		int max = getMax(root);
		System.out.println(max);
	}

	private static int getMax(Node root) {
		if (root.right != null)
			return getMax(root.right);
		else
			return root.data;
	}

	private static int getMin(Node root) {
		if (root.left != null)
			return getMin(root.left);
		else
			return root.data;
	}
}
