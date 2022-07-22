package a7_binaryTree;

import java.util.ArrayList;
import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
 * https://www.youtube.com/watch?v=eDdPZ05y4Os
 * Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 10 30 20 40 60 90 100
 */
public class B1_ZigZagTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(90);
		root.right.right = new TreeNode(100);

		ArrayList<Integer> list = getZigZagTraversal(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> getZigZagTraversal(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		Stack<TreeNode> ms = new Stack<>();
		ms.push(root);
		Stack<TreeNode> cs = new Stack<>();
		int level = 1;
		while (!ms.isEmpty()) {
			TreeNode rn = ms.pop();
			ans.add(rn.data);
			if (level % 2 == 1) {
				if (rn.left != null)
					cs.push(rn.left);
				if (rn.right != null)
					cs.push(rn.right);
			} else {
				if (rn.right != null)
					cs.push(rn.right);
				if (rn.left != null)
					cs.push(rn.left);
			}
			if (ms.isEmpty()) {
				ms = cs;
				cs = new Stack<>();
				level++;
			}
		}
		return ans;
	}
}
