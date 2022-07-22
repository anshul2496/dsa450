package a6_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/mirror-tree/1
 * https://www.youtube.com/watch?v=lLdyqkdFNi0
 * Input:
        10
     /      \
    20       30
  /   \
 40   60
 */
public class A5_MirrorTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		inorder(root);
		mirror(root);
		System.out.println();
		inorder(root);
	}

	private static TreeNode mirror(TreeNode root) {
		if (root == null)
			return null;
		TreeNode left = mirror(root.left);
		TreeNode right = mirror(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

	private static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
}
