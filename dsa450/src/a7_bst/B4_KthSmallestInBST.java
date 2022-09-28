package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/find-k-th-smallest-element-in-bst/1
 * https://www.youtube.com/watch?v=9TJYWh0adfk
 *   		  	5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class B4_KthSmallestInBST {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		int k = 3;
		getKthSmallest(root, k);
		System.out.println(ans);
	}

	private static int i = 0;
	private static int ans = 0;

	private static void getKthSmallest(Node root, int k) {
		if (root != null) {
			getKthSmallest(root.left, k);
			if (i == k - 1) {
				ans = root.data;
			}
			i++;
			getKthSmallest(root.right, k);
		}
	}
}
