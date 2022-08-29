package a6_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1
 * https://www.youtube.com/watch?v=S0Bwgtn32uI
 * Input:
        10
     /      \
    20       30
  /   \
 40   60
 */
public class A4_DiameterOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		// int dia = diameter1(root); // O(n^2)
		DiaPair diaPair = diameter2(root); // O(n)
		System.out.println(diaPair.dia + 1);
	}

	private static DiaPair diameter2(TreeNode root) {
		if (root == null) {
			DiaPair bp = new DiaPair();
			bp.dia = 0;
			bp.height = -1;
			return bp;
		}
		DiaPair leftPair = diameter2(root.left);
		DiaPair rightPair = diameter2(root.right);

		DiaPair myPair = new DiaPair();
		myPair.height = Math.max(leftPair.height, rightPair.height) + 1;
		int diaEitherSides = leftPair.height + rightPair.height + 2;
		myPair.dia = Math.max(diaEitherSides, Math.max(leftPair.dia, rightPair.dia));
		return myPair;
	}

	private static int diameter1(TreeNode root) {
		if (root == null)
			return 0;
		// Maximum distance between two nodes on left hand side
		int ld = diameter1(root.left);
		// Maximum distance between two nodes on right hand side
		int rd = diameter1(root.right);
		// Maximum distance between left's deepest and right's deepest
		int f = height(root.left) + height(root.right) + 1; // in terms of no of nodes
		int dia = Math.max(f, Math.max(ld, rd));
		return dia;
	}

	private static int height(TreeNode root) {
		if (root == null)
			return 0; // in terms of nodes
		int lh = height(root.left);
		int rh = height(root.right);
		int th = Math.max(lh, rh) + 1;
		return th;
	}
}

class DiaPair {
	int dia;
	int height;
}