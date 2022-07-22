package a7_binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1/
 * https://www.youtube.com/watch?v=fcmxvpwFHgk
 * Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is visited from Right side. 
	Right view of following tree is 1 3 7 8

          1
       /     \
     2        3
   /   \     /  \
  4     5   6    7
                  \
                   8
 */
public class A42_RightViewOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(8);
		ArrayList<Integer> list = rightView(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> rightView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		LinkedList<TreeNode> q = new LinkedList<>();
		q.addLast(root);
		while (!q.isEmpty()) {
			int size = q.size();
			ans.add(q.getFirst().data);
			while (size-- > 0) {
				TreeNode rn = q.removeFirst();
				if (rn.right != null)
					q.addLast(rn.right);
				if (rn.left != null)
					q.addLast(rn.left);
			}
		}
		return ans;
	}
}
