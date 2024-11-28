package a6_binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 * https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
 * https://www.youtube.com/watch?v=DhgD8dyp8RM
 * Input:
       10
    /      \
  20        30
 /   \    /    \
40   60  90    100
Output: 40 20 10 30 100
 */
public class A8_TopViewOfTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(90);
		root.right.right = new TreeNode(100);

		ArrayList<Integer> list = getTopView(root);
		System.out.println(list);
	}

	// Map approach
	static ArrayList<Integer> topView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int minhl = 0;
		int maxhl = 0;
		LinkedList<A7Pair> q = new LinkedList<>();
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		q.addLast(new A7Pair(root, 0));
		while (!q.isEmpty()) {
			A7Pair rp = q.removeFirst();
			minhl = Math.min(minhl, rp.hl);
			maxhl = Math.max(maxhl, rp.hl);
			if (!map.containsKey(rp.hl)) {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(rp.node.data);
				map.put(rp.hl, temp);
			}
			if (rp.node.left != null) {
				q.addLast(new A7Pair(rp.node.left, rp.hl - 1));
			}
			if (rp.node.right != null) {
				q.addLast(new A7Pair(rp.node.right, rp.hl + 1));
			}
		}
		for (int i = minhl; i <= maxhl; i++) {
			ans.addAll(map.get(i));
		}
		return ans;
	}

	private static ArrayList<Integer> getTopView(TreeNode root) {
		if (root == null)
			return new ArrayList<>();
		int[] minMax = new int[2];
		width(root, 0, minMax);
		int len = minMax[1] - minMax[0] + 1;
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 0; i < len; i++)
			ans.add(null);
		LinkedList<A7Pair> q = new LinkedList<>();
		q.add(new A7Pair(root, Math.abs(minMax[0])));
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				A7Pair rn = q.removeFirst();
				if (ans.get(rn.hl) == null)
					ans.set(rn.hl, rn.node.data);
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
}
