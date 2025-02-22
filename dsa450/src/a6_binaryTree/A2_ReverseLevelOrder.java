package a6_binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1
 * https://www.youtube.com/watch?v=D2bIbWGgvzI
 * Input:
        10
     /      \
    20       30
  /   \
 40   60
 */
public class A2_ReverseLevelOrder {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		ArrayList<Integer> list = getReverseLevelOrder(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> getReverseLevelOrder(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<TreeNode> q = new ArrayDeque<>();
		Stack<TreeNode> stack = new Stack<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode rn = q.poll();
			stack.add(rn);
			if (rn.right != null)
				q.add(rn.right);
			if (rn.left != null)
				q.add(rn.left);
		}
		while (!stack.isEmpty())
			ans.add(stack.pop().data);
		return ans;
	}

	// My solution - No need of additional Stack DataStructure
	public ArrayList<Integer> reverseLevelOrder(TreeNode node) {
		ArrayList<Integer> ans = new ArrayList<>();
		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(node);
		while (q.size() > 0) {
			int c = q.size();
			for (int i = 0; i < c; i++) {
				TreeNode rm = q.remove();
				if (rm.right != null)
					q.add(rm.right);
				if (rm.left != null)
					q.add(rm.left);
				ans.add(rm.data);
			}
		}
		Collections.reverse(ans);
		return ans;
	}
}
