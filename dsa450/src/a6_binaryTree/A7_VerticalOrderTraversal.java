package a6_binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 * https://www.youtube.com/watch?v=LscPXvD1N1A - Method 1 
 * https://www.youtube.com/watch?v=dGRkgGQgruQ - Method 2
 * Input:
       1
    /    \
   2       3
 /    \      \
4      5      6
Output: 4 2 1 5 3 6
 */
public class A7_VerticalOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		// https://www.youtube.com/watch?v=LscPXvD1N1A
		// Map approach
		// ArrayList<ArrayList<Integer>> ans = solution1(root);
		// System.out.println(ans);

		// https://www.youtube.com/watch?v=dGRkgGQgruQ
		// ArrayList with width approach - Used in multiple questions
		ArrayList<ArrayList<Integer>> ans = solution2(root);
		System.out.println(ans);

	}

	private static ArrayList<ArrayList<Integer>> solution2(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		if (root == null)
			return ans;
		LinkedList<A7Pair> q = new LinkedList<>();
		int[] minMax = new int[2];
		width(root, 0, minMax);
		int len = minMax[1] - minMax[0] + 1;
		for (int i = 0; i < len; i++)
			ans.add(new ArrayList<>());
		q.addLast(new A7Pair(root, Math.abs(minMax[0])));
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				A7Pair rn = q.removeFirst();
				ans.get(rn.hl).add(rn.node.data);
				if (rn.node.left != null)
					q.addLast(new A7Pair(rn.node.left, rn.hl - 1));
				if (rn.node.right != null)
					q.addLast(new A7Pair(rn.node.right, rn.hl + 1));
			}
		}
		return ans;
	}

	private static void width(TreeNode root, int hl, int[] minMax) {
		if (root == null)
			return;
		minMax[0] = Math.min(minMax[0], hl);
		minMax[1] = Math.max(minMax[1], hl);
		width(root.left, hl - 1, minMax);
		width(root.right, hl + 1, minMax);
	}

	private static ArrayList<ArrayList<Integer>> solution1(TreeNode root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		LinkedList<A7Pair> q = new LinkedList<>();
		int min = 0, max = 0;
		q.addLast(new A7Pair(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				A7Pair rp = q.removeFirst();
				map.putIfAbsent(rp.hl, new ArrayList<>());
				map.get(rp.hl).add(rp.node.data);
				if (rp.node.left != null)
					q.addLast(new A7Pair(rp.node.left, rp.hl - 1));
				if (rp.node.right != null)
					q.addLast(new A7Pair(rp.node.right, rp.hl + 1));
				min = Math.min(min, rp.hl);
				max = Math.max(max, rp.hl);
			}
		}
		for (int i = min; i <= max; i++) {
			ans.add(map.get(i));
		}
		return ans;
	}
}

class A7Pair {
	TreeNode node;
	int hl;

	public A7Pair(TreeNode node, int hl) {
		this.node = node;
		this.hl = hl;
	}
}