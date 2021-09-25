package dsa_codewithharry;

public class O_TreeTraversals {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// Creating Nodes
		Node n1 = new Node(7);
		Node n2 = new Node(2);
		Node n3 = new Node(1);
		Node n4 = new Node(0);
		Node n5 = new Node(4);

		// Linking nodes
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		
		// Input tree -
		//       7
		//      /  \
		//     2    1
		//    / \
		//   0   4

		System.out.println("PreOrder Traversal - ");
		preOrderTraversal(n1);
		
		System.out.println("\n\nPostOrder Traversal - ");
		postOrderTraversal(n1);

		System.out.println("\n\nInOrder Traversal - ");
		inOrderTraversal(n1);
	}

	private static void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.left);
			System.out.print(root.data + " ");
			inOrderTraversal(root.right);
		}
	}

	private static void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.left);
			postOrderTraversal(root.right);
			System.out.print(root.data + " ");
		}
	}

	private static void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrderTraversal(root.left);
			preOrderTraversal(root.right);
		}
	}
}
