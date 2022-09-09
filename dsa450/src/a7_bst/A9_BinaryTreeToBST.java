package a7_bst;

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://practice.geeksforgeeks.org/problems/binary-tree-to-bst/1
 * https://www.youtube.com/watch?v=8AnntMKIWlQ
 * 	         1
	       /    \
	     2       3
	   /        
	 4       
 */
public class A9_BinaryTreeToBST {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		convertToBST(root);
		inorder(root);
	}

	private static void convertToBST(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		Collections.sort(list);
		inorderToBST(root, list);
	}

	private static int i = 0;

	private static void inorderToBST(Node root, ArrayList<Integer> list) {
		if (root != null) {
			inorderToBST(root.left, list);
			root.data = list.get(i++);
			inorderToBST(root.right, list);
		}
	}

	private static void inorder(Node root, ArrayList<Integer> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root.data);
			inorder(root.right, list);
		}
	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}
}
