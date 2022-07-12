package a7_binaryTree;

/*
 * https://practice.geeksforgeeks.org/problems/construct-tree-1/1
 * https://www.youtube.com/watch?v=oAbSNJ35qAs
 * inorder[] = {1 6 8 7}
	preorder[] = {1 6 7 8}
	Output: 8 7 6 1
 */
public class B8_BinaryTreeFromInorderPreorder {
	public static void main(String[] args) {
		int[] inorder = { 1, 6, 8, 7 };
		int[] preorder = { 1, 6, 7, 8 };
		TreeNode root = getBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		postOrder(root);
	}

	private static TreeNode getBinaryTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
			int inEnd) {
		if (inStart > inEnd)
			return null;
		int idx = inStart;
		while (preorder[preStart] != inorder[idx])
			idx++;
		int countOfLeft = idx - inStart;
		TreeNode root = new TreeNode(preorder[preStart]);
		root.left = getBinaryTree(preorder, preStart + 1, preStart + countOfLeft, inorder, inStart, idx - 1);
		root.right = getBinaryTree(preorder, preStart + countOfLeft + 1, preEnd, inorder, idx + 1, inEnd);
		return root;
	}

	private static void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}
}
