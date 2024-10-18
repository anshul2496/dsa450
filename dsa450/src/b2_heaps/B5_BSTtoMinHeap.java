package b2_heaps;

import java.util.ArrayList;
import java.util.List;

/*
 * https://www.naukri.com/code360/problems/convert-bst-to-min-heap_920498?leftPanelTabValue=PROBLEM
 * https://www.youtube.com/watch?v=_9F2VgZcvdw&t=3308s
 */
public class B5_BSTtoMinHeap {
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode(4);
		root.left=new BinaryTreeNode(2);
		root.right=new BinaryTreeNode(6);
		BinaryTreeNode ans= convertBST(root);
		System.out.println(ans);
	}

	public static BinaryTreeNode convertBST(BinaryTreeNode root) {
		List<Integer> list = new ArrayList<>();
		inOrder(root, list);
		int[] index = { 0 };
		preOrderFill(root, index, list);
		return root;
	}

	public static void preOrderFill(BinaryTreeNode root, int[] index, List<Integer> list) {
		if (root == null)
			return;
		root.data = list.get(index[0]++);
		preOrderFill(root.left, index, list);
		preOrderFill(root.right, index, list);
	}

	public static void inOrder(BinaryTreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inOrder(root.left, list);
		list.add(root.data);
		inOrder(root.right, list);
	}
}

class BinaryTreeNode {

	int data;
	BinaryTreeNode left;
	BinaryTreeNode right;

	BinaryTreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}