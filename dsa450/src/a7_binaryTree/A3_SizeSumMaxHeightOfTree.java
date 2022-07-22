package a7_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
 * https://www.youtube.com/watch?v=Y7fg3QS6u6w
 * Input:
        10
     /      \
    20       30
  /   \
 40   60
 */
public class A3_SizeSumMaxHeightOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		System.out.println("Size = " + getSize(root));
		System.out.println("Sum = " + getSum(root));
		System.out.println("Max = " + getMax(root));
		System.out.println("Height = " + getHeight(root));
	}

	private static int getHeight(TreeNode root) {
		if (root == null)
			return 0; // If the question asks height w.r.t edges then return -1, for nodes return 0
		int ls = getHeight(root.left);
		int rs = getHeight(root.right);
		int ts = Math.max(ls, rs) + 1; // 1 for the node itself
		return ts;
	}

	private static int getMax(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE; // In tree questions, always keep base case as identities. For e.g - while calc
										// product you would keep it as 1.
		int lm = getMax(root.left);
		int rm = getMax(root.right);
		int tm = Math.max(root.data, Math.max(lm, rm));
		return tm;
	}

	private static int getSum(TreeNode root) {
		if (root == null)
			return 0;
		int ls = getSum(root.left);
		int rs = getSum(root.right);
		int ts = ls + rs + root.data;
		return ts;
	}

	// Size is total nodes in the tree
	private static int getSize(TreeNode root) {
		if (root == null)
			return 0;
		int ls = getSize(root.left);
		int rs = getSize(root.right);
		int ts = ls + rs + 1; // 1 for the node itself
		return ts;
	}
}
