package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
 * https://www.youtube.com/watch?v=9TJYWh0adfk
 *   		  	5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class B3_KthLargestInBST {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		int k = 3;
		getKthLargest(root, k);
		System.out.println(ans);
	}

	private static int i = 0;
	private static int n = 0; //Total elements
	private static int ans = 0;

	private static void getKthLargest(Node root, int k) {
		inorder(root);
		inorder(root, k);
	}

	private static void inorder(Node root, int k) {
		if (root != null) {
			inorder(root.left, k);
			if (i == (n - k)) { //kth largest = (n-k)th smallest
				ans = root.data;
			}
			i++;
			inorder(root.right, k);
		}
	}

	private static void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			n++;
			inorder(root.right);
		}
	}
}
