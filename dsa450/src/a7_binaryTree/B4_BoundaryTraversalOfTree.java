package a7_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
 * https://www.youtube.com/watch?v=0ca1nvR0be4
 * Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 10 20 40 60 90 100 30
 */
public class B4_BoundaryTraversalOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(90);
		root.right.right = new TreeNode(100);

		ArrayList<Integer> ans = getBoundaryTraversal(root);
		System.out.println(ans);
	}

	private static ArrayList<Integer> getBoundaryTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (isLeaf(root) == false)
			ans.add(root.data);
		addLeftBoundary(root, ans);
		addLeaves(root, ans);
		addReverseRightBoundary(root, ans);
		return ans;
	}

	private static void addReverseRightBoundary(TreeNode root, ArrayList<Integer> ans) {
		Stack<Integer> stack = new Stack<>();
		TreeNode curr = root.right;
		while (curr != null) {
			if (!isLeaf(curr))
				stack.add(curr.data);
			if (curr.right != null)
				curr = curr.right;
			else
				curr = curr.left;
		}
		while (!stack.isEmpty())
			ans.add(stack.pop());
	}

	private static void addLeaves(TreeNode root, ArrayList<Integer> ans) {
		if (root != null) {
			if (isLeaf(root))
				ans.add(root.data);
			addLeaves(root.left, ans);
			addLeaves(root.right, ans);
		}
	}

	private static void addLeftBoundary(TreeNode root, ArrayList<Integer> ans) {
		TreeNode curr = root.left;
		while (curr != null) {
			if (!isLeaf(curr))
				ans.add(curr.data);
			if (curr.left != null)
				curr = curr.left;
			else
				curr = curr.right;
		}
	}

	private static boolean isLeaf(TreeNode root) {
		return (root.right == null && root.left == null);
	}
}
