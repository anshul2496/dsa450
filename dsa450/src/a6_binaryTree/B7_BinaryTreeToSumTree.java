package a6_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/transform-to-sum-tree/1
 * https://www.youtube.com/watch?v=XpeA8w44xeo
 * Input:
             10
          /      \
        -2        6
       /   \     /  \
     8     -4   7    5

Output:
            20
          /    \
        4        12
       /  \     /  \
     0     0   0    0
 */
public class B7_BinaryTreeToSumTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(8);
		root.left.right = new TreeNode(-4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(5);

		sumTree(root);
		preOrder(root);
	}

	private static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	private static int sumTree(TreeNode root) {
		if (root == null)
			return 0;
		int lp = sumTree(root.left);
		int rp = sumTree(root.right);
		int x = root.data;
		root.data = lp + rp;
		return lp + rp + x;
	}
}
