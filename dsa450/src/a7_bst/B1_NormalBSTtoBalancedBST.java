package a7_bst;

import java.util.ArrayList;

/*
 * https://practice.geeksforgeeks.org/problems/normal-bst-to-balanced-bst/1
 * https://www.youtube.com/watch?v=ceGBg3g18js
 * Input:
       30
      /
     20
    /
   10
	Output:
	     20
	   /   \
	 10     30
 */
public class B1_NormalBSTtoBalancedBST {
	public static void main(String[] args) {
		Node root = new Node(30);
		root.left = new Node(20);
		root.left.left = new Node(10);
		Node ans = balancedBST(root);
		print(ans);
	}

	private static Node balancedBST(Node root) {
		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		int start = 0;
		int end = list.size() - 1;
		return solve(list, start, end);
	}

	private static Node solve(ArrayList<Integer> list, int start, int end) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node root = new Node(list.get(mid));
		root.left = solve(list, start, mid - 1);
		root.right = solve(list, mid + 1, end);
		return root;
	}

	private static void inorder(Node root, ArrayList<Integer> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root.data);
			inorder(root.right, list);
		}
	}

	private static void print(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			print(root.left);
			print(root.right);
		}
	}
}
