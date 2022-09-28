package a7_bst;

import java.util.ArrayList;
import java.util.Stack;

/*
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * https://www.youtube.com/watch?v=ouuGHu9Sjhg - Approach 1
 * https://www.youtube.com/watch?v=iK2VFYxFC4o - Approach 2 and 3
 		   		5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class B5_TwoSumBST {
	private static boolean ans = false;

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		int k = 9;
		// twoSum1(root, root, k);
		// twoSum2(root, k); // Inorder and 2 pointer approach
		twoSum3(root, k); // Inorder and Reverse Inorder - Iterative approach
		System.out.println(ans);
	}

	// TC: O(n) and SC: O(h)
	private static void twoSum3(Node root, int k) {
		Stack<Pair> ls = new Stack<>();
		Stack<Pair> rs = new Stack<>();

		ls.push(new Pair(root, 0));
		rs.push(new Pair(root, 0));

		Node left = getNodeFromNormalInorder(ls);
		Node right = getNodeFromReverseInorder(rs);
		// Two pointer approach
		while (left.data < right.data) {
			int sum = left.data + right.data;
			if (sum < k)
				left = getNodeFromNormalInorder(ls);
			else if (sum > k)
				right = getNodeFromReverseInorder(rs);
			else {
				ans = true;
				break;
			}
		}
	}

	private static Node getNodeFromReverseInorder(Stack<Pair> stack) {
		while (stack.size() > 0) {
			Pair top = stack.peek();
			if (top.status == 0) {
				if (top.node.right != null) {
					stack.push(new Pair(top.node.right, 0));
				}
				top.status++;
			} else if (top.status == 1) {
				if (top.node.left != null) {
					stack.push(new Pair(top.node.left, 0));
				}
				top.status++;
				return top.node;
			} else {
				stack.pop();
			}
		}
		return null;
	}

	private static Node getNodeFromNormalInorder(Stack<Pair> stack) {
		while (stack.size() > 0) {
			Pair top = stack.peek();
			if (top.status == 0) {
				if (top.node.left != null) {
					stack.push(new Pair(top.node.left, 0));
				}
				top.status++;
			} else if (top.status == 1) {
				if (top.node.right != null) {
					stack.push(new Pair(top.node.right, 0));
				}
				top.status++;
				return top.node;
			} else {
				stack.pop();
			}
		}
		return null;
	}

	// TC: O(n) and SC: O(n)
	private static void twoSum2(Node root, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		inorder(root, list);
		int low = 0;
		int high = list.size() - 1;
		while (low < high) {
			int sum = list.get(low) + list.get(high);
			if (sum < k)
				low++;
			else if (sum > k)
				high--;
			else {
				ans = true;
				break;
			}
		}
	}

	private static void inorder(Node root, ArrayList<Integer> list) {
		if (root != null) {
			inorder(root.left, list);
			list.add(root.data);
			inorder(root.right, list);
		}
	}

	// TC : O(n*h) = O(nlogn) and SC: O(h) [As the recursive stack space will never
	// exceed height of tree]
	private static void twoSum1(Node root, Node node, int k) {
		if (node == null)
			return;
		twoSum1(root, node.left, k);
		if (node.data < k) {
			int comp = k - node.data;
			if (find(root, comp)) {
				ans = true;
			}
		}
		twoSum1(root, node.right, k);
	}

	private static boolean find(Node root, int comp) {
		if (root == null)
			return false;
		if (comp < root.data)
			return find(root.left, comp);
		else if (comp > root.data)
			return find(root.right, comp);
		else
			return true;
	}
}

class Pair {
	Node node;
	int status = 0;

	public Pair(Node node, int status) {
		this.node = node;
		this.status = status;
	}
}