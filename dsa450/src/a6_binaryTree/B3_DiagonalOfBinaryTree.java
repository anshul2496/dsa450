package a6_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1/
 * https://www.youtube.com/watch?v=cvK3Sb6zJ1k
 * Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 10 30 100 20 60 90 40
 */
public class B3_DiagonalOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(90);
		root.right.right = new TreeNode(100);

		ArrayList<Integer> ans = diagonal(root);
		System.out.println(ans);
	}

	public static ArrayList<Integer> diagonal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);
		while (!q.isEmpty()) {
			TreeNode rn = q.removeFirst();
			while (rn != null) {
				ans.add(rn.data);
				if (rn.left != null)
					q.addLast(rn.left);
				rn = rn.right;
			}
		}
		return ans;
	}
}
