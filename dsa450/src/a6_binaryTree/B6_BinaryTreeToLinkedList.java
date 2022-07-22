package a6_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
 * https://www.youtube.com/watch?v=nGNoTdav5bQ
 * Input:
	       10
	    /      \
	  20        30
	 /   \    /    \
	40   60  90    100
	Output: 40 20 60 10 90 30 100
 */
public class B6_BinaryTreeToLinkedList {
	private static TreeNode prev = null;
	private static TreeNode head = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(90);
		root.right.right = new TreeNode(100);

		flattenToLinkedList(root);
		print();
	}

	private static void print() {
		TreeNode curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.right;
		}
	}

	private static void flattenToLinkedList(TreeNode root) {
		if (root == null)
			return;
		flattenToLinkedList(root.left);
		if (prev == null)
			head = root;
		else {
			root.left = prev;
			prev.right = root;
		}
		prev = root;
		flattenToLinkedList(root.right);
	}
}
