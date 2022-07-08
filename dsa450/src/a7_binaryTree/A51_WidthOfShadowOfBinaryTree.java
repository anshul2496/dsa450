package a7_binaryTree;

/*
 * https://www.youtube.com/watch?v=rRBD5mS-N80
 */
public class A51_WidthOfShadowOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		int width = getShadowWidth(root);
		System.out.println(width);
	}

	private static int getShadowWidth(TreeNode root) {
		int[] ans = new int[2];
		width(root, 0, ans);
		return ans[1] - ans[0] + 1;
	}

	// 0 index - min, 1 index - max, hl - horizontal level
	private static void width(TreeNode root, int hl, int[] ans) {
		if (root == null)
			return;
		ans[0] = Math.min(ans[0], hl);
		ans[1] = Math.max(ans[1], hl);
		width(root.left, hl - 1, ans);
		width(root.right, hl + 1, ans);
	}
}
