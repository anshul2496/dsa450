package a7_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
 * https://www.youtube.com/watch?v=lUDgp2D6sf8
 *    1
     /    
   10   
  /
5
Output = false
 */
public class B2_CheckBalancedTree {
	static boolean isBalanced = true;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(5);

		checkBalancedTree(root);
		System.out.println(isBalanced);
	}

	private static int checkBalancedTree(TreeNode root) {
		if (root == null)
			return 0;
		int lh = checkBalancedTree(root.left);
		int rh = checkBalancedTree(root.right);
		int gap = Math.abs(lh - rh);
		if (gap > 1)
			isBalanced = false;
		int th = Math.max(lh, rh) + 1;
		return th;
	}
}
