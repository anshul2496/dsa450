package a7_binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
 * https://www.youtube.com/watch?v=LscPXvD1N1A
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

		ArrayList<ArrayList<Integer>> ans = getVerticalOrderTraversal(root);
		System.out.println(ans);
	}

	private static ArrayList<ArrayList<Integer>> getVerticalOrderTraversal(TreeNode root) {
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