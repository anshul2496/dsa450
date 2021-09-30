package dsa_codewithharry;

import dsa_codewithharry.O_TreeTraversals.Node;

public class R_InsertInBST {

	public static void main(String[] args) {
		R_InsertInBST ob = new R_InsertInBST();
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
		
		System.out.println("InOrder Traversal before insert- ");
		ob.inOrder(root);
		ob.insert(root, 5);
		System.out.println("\nInOrder Traversal after insert- ");
		ob.inOrder(root);
	}

	private void insert(Node root, int key) {
		Node prev = null;
		while (root != null) {
			prev = root;
			if (key == root.data) {
				System.out.println("\nCannot insert duplicate");
				return;
			} else if (key < root.data) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		Node newNode = new Node(key);
		if (key < prev.data) {
			prev.left = newNode;
		} else {
			prev.right = newNode;
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}
}
