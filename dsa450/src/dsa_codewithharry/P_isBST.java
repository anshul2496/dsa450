package dsa_codewithharry;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
	}
}

public class P_isBST {

	public static void main(String[] args) {
		// Creating Nodes
		Node root = new Node(7);
		root.left = new Node(2);
		root.right = new Node(9);
		root.left.left = new Node(0);
		root.left.right = new Node(4);

		// Input tree -
		//       7
		//      /  \
		//     2    9
		//    / \
		//   0   4

		System.out.println("isBST = " + isBST(root));
	}

	static Node prev = null;

	private static boolean isBST(Node root) {
		if (root != null) {
			if (!isBST(root.left))
				return false;
			if (prev != null && prev.data > root.data)
				return false;
			prev = root;
			return isBST(root.right);
		}
		return true;
	}
}
