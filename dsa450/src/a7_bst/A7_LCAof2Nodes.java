package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
 * https://www.youtube.com/watch?v=5E3MeajU9XQ
 * 		  		5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A7_LCAof2Nodes {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		int ans = getLCA(root, 2, 4);
		System.out.println(ans);
	}

	private static int getLCA(Node root, int d1, int d2) {
		if (d1 < root.data && d2 < root.data)
			return getLCA(root.left, d1, d2);
		else if (d1 > root.data && d2 > root.data)
			return getLCA(root.right, d1, d2);
		else
			return root.data;
	}
}
