package a6_binaryTree;

import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/maximum-width-of-tree/1/
 */
public class A62_MaxWidthOfTreeWithoutNull {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(7);
		root.right.left = new TreeNode(6);
		root.left.left.right = new TreeNode(8);
		System.out.println(getMaxWidth(root));
	}

	static int getMaxWidth(TreeNode root) {
		int ans = 0;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);
		while (!q.isEmpty()) {
			int size = q.size();
			ans = Math.max(ans, size);
			while (size-- > 0) {
				TreeNode rn = q.removeFirst();
				if (rn.left != null)
					q.addLast(rn.left);
				if (rn.right != null)
					q.addLast(rn.right);
			}
		}
		return ans;
	}
}
