package a7_bst;

import java.util.ArrayList;

/*
 * https://www.codingninjas.com/codestudio/problems/h_920474
 * https://www.youtube.com/watch?v=LY5hbvFSJqM
 * Input:
	     20
	   /   \
	 10     30      40
	
   Output:
	     20
	   /   \
	 10     30
	 		 \
	 		 40
 */

public class B2_Merge2BST {
	public static void main(String[] args) {
		Node root1 = new Node(20);
		root1.left = new Node(10);
		root1.right = new Node(30);

		Node root2 = new Node(40);
		Node ans = getBalancedBST(root1, root2);
		print(ans);
	}

	private static Node getBalancedBST(Node root1, Node root2) {
		ArrayList<Integer> list1 = new ArrayList<>();
		inorder(root1, list1);
		ArrayList<Integer> list2 = new ArrayList<>();
		inorder(root2, list2);
		ArrayList<Integer> list = new ArrayList<>();
		mergeTwoLists(list1, list2, list);
		int start = 0;
		int end = list.size() - 1;
		return solve(start, end, list);
	}

	private static Node solve(int start, int end, ArrayList<Integer> list) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		Node root = new Node(list.get(mid));
		root.left = solve(start, mid - 1, list);
		root.right = solve(mid + 1, end, list);
		return root;
	}

	private static void mergeTwoLists(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list) {
		int i = 0, j = 0;
		while (i < list1.size() && j < list2.size()) {
			if (list1.get(i) <= list2.get(j)) {
				list.add(list1.get(i++));
			} else {
				list.add(list2.get(j++));
			}
		}
		while (i < list1.size())
			list.add(list1.get(i++));
		while (j < list2.size())
			list.add(list2.get(j++));
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
			print(root.left);
			System.out.print(root.data + " ");
			print(root.right);
		}
	}
}
