package a7_binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/*
 * https://practice.geeksforgeeks.org/problems/level-order-traversal/1
 * https://www.youtube.com/watch?v=U7rLw0jXI0E
 * Input:
        10
     /      \
    20       30
  /   \
 40   60
 */
public class A1_LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.right = new TreeNode(60);
		root.left.left = new TreeNode(40);
		ArrayList<Integer> list = getLevelOrder(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> getLevelOrder(TreeNode root) {
		// Remove, Print, Add (rpa)
		ArrayList<Integer> ans = new ArrayList<>();

		Queue<TreeNode> q = new ArrayDeque<>();
		q.add(root);
		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				TreeNode rn = q.poll();
				ans.add(rn.data);
				if (rn.left != null)
					q.add(rn.left);
				if (rn.right != null)
					q.add(rn.right);
			}
		}
		return ans;
	}
}

class TreeNode {
	int data;
	TreeNode right;
	TreeNode left;

	public TreeNode(int data) {
		this.data = data;
	}
}