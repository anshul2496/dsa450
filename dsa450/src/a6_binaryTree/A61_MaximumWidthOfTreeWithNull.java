package a6_binaryTree;

import java.util.LinkedList;

/*
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/maximum-width-of-binary-tree/ojquestion
 * https://www.youtube.com/watch?v=R9qiY7OK9JQ
 * Gfg question is different from Pepcoding one. In pepcoding null children are counted in width
 * In gfg null children are not counted.
 * Below code is of pepcoding. Check gfg link for the question and ans
 */
public class A61_MaximumWidthOfTreeWithNull {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.right = new TreeNode(30);
		root.left = new TreeNode(20);
		root.left.left = new TreeNode(40);
		root.right.right = new TreeNode(60);

		int max = 0;
		LinkedList<Pair> q = new LinkedList<>();
		q.addLast(new Pair(root, 0));
		while (!q.isEmpty()) {
			int size = q.size();
			int lm = q.getFirst().idx;
			int rm = q.getFirst().idx;
			while (size-- > 0) {
				Pair rp = q.removeFirst();
				rm = rp.idx;
				if (rp.node.left != null) {
					q.addLast(new Pair(rp.node.left, rp.idx * 2 + 1));
				}
				if (rp.node.right != null) {
					q.addLast(new Pair(rp.node.right, rp.idx * 2 + 2));
				}
			}
			max = Math.max(max, rm - lm + 1);
		}
		System.out.println(max);
	}
}

class Pair {
	TreeNode node;
	int idx;

	public Pair(TreeNode node, int idx) {
		this.node = node;
		this.idx = idx;
	}

	@Override
	public String toString() {
		return "Pair [node=" + node.data + ", idx=" + idx + "]";
	}

}