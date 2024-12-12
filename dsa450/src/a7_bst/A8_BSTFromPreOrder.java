package a7_bst;

/*
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * https://www.youtube.com/watch?v=Bexswo4pqZQ
 */
public class A8_BSTFromPreOrder {
	public static void main(String[] args) {
		int[] a = { 8, 5, 1, 7, 10, 12 };
		Node root = getBST(a, Integer.MIN_VALUE, Integer.MAX_VALUE);
		print(root);
	}

	private static int idx = 0;

	private static Node getBST(int[] a, int lr, int rr) {
		if (idx >= a.length || a[idx] < lr || a[idx] > rr)
			return null;
		Node root = new Node(a[idx++]);
		root.left = getBST(a, lr, root.data);
		root.right = getBST(a, root.data, rr);
		return root;
	}

	private static void print(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			print(root.left);
			print(root.right);
		}
	}
}
