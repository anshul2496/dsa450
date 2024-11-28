package a6_binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.w3c.dom.Node;

/*
 * https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
 * https://www.youtube.com/watch?v=kCQJTAqbExg
 *  * Input:
       10
    /      \
  20        30
 /   \        \
40   60   	   100
Output: 40 20 60 30 100
 */
public class A9_BottomViewOfBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(20);
		root.right = new TreeNode(30);
		root.left.left = new TreeNode(40);
		root.left.right = new TreeNode(60);
		root.right.right = new TreeNode(100);

		ArrayList<Integer> ans = getBottomView(root);
		System.out.println(ans);
	}

	// Map Approach
	public ArrayList<Integer> bottomView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		LinkedList<A7Pair> q = new LinkedList<>();
		q.addLast(new A7Pair(root, 0));
		int minhl = 0, maxhl = 0;
		while (!q.isEmpty()) {
			A7Pair rp = q.removeFirst();
			minhl = Math.min(minhl, rp.hl);
			maxhl = Math.max(maxhl, rp.hl);
			map.put(rp.hl, rp.node.data);
			if (rp.node.left != null) {
				q.addLast(new A7Pair(rp.node.left, rp.hl - 1));
			}
			if (rp.node.right != null) {
				q.addLast(new A7Pair(rp.node.right, rp.hl + 1));
			}
		}
		for (int i = minhl; i <= maxhl; i++) {
			ans.add(map.get(i));
		}
		return ans;
	}
	
	private static ArrayList<Integer> getBottomView(TreeNode root) {
		ArrayList<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;
		int[] minMax = new int[2];
		getWidth(root, 0, minMax);
		int len = minMax[1] - minMax[0] + 1;
		for (int i = 0; i < len; i++)
			ans.add(0);
		LinkedList<A7Pair> q = new LinkedList<>();
		q.addLast(new A7Pair(root, Math.abs(minMax[0])));
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				A7Pair rp = q.removeFirst();
				ans.set(rp.hl, rp.node.data);
				if (rp.node.left != null)
					q.addLast(new A7Pair(rp.node.left, rp.hl - 1));
				if (rp.node.right != null)
					q.addLast(new A7Pair(rp.node.right, rp.hl + 1));
			}
		}
		return ans;
	}

	private static void getWidth(TreeNode root, int hl, int[] minMax) {
		if (root == null)
			return;
		minMax[0] = Math.min(minMax[0], hl);
		minMax[1] = Math.max(minMax[1], hl);
		getWidth(root.left, hl - 1, minMax);
		getWidth(root.right, hl + 1, minMax);
	}
}
