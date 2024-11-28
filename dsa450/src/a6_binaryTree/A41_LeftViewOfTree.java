package a6_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1/
 * https://www.youtube.com/watch?v=QTWQSgD9HJ8
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes 
 * visible when tree is visited from Left side. 
	Left view of following tree is 1 2 4 8

          1
       /     \
     2        3
   /   \     /  \
  4     5   6    7
                  \
                   8
 */
public class A41_LeftViewOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		ArrayList<Integer> list = leftView(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> leftView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(root==null) return ans;
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);
		while (!q.isEmpty()) {
			int size = q.size();
			ans.add(q.getFirst().data);
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
