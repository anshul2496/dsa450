package a6_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
 * https://www.youtube.com/watch?v=Yt50Jfbd8Po
 *    1
     /    
   10   
  /
5
Output = false
 */
public class B2_CheckBalancedTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(10);
		root.left.left = new TreeNode(5);

		System.out.println(checkBalancedTree(root));
	}

	static boolean checkBalancedTree(TreeNode root) {
		int diffh = getDiff(root);
		return diffh != -1;
	}

	public static int getDiff(TreeNode root) {
		if (root == null)
			return 0;
		int lh = getDiff(root.left);
		if (lh == -1)
			return -1;
		int rh = getDiff(root.right);
		if (rh == -1)
			return -1;
		if (Math.abs(lh - rh) > 1)
			return -1;
		int th = Math.max(rh, lh) + 1;
		return th;
	}
}
