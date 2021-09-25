package dsa_codewithharry;

import dsa_codewithharry.O_TreeTraversals.Node;

public class Q_SearchInBST {

	public static void main(String[] args) {
		Q_SearchInBST ob = new Q_SearchInBST();
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
		
		System.out.println("Is Number Present = " + ob.search(root, 9));
	}

	private boolean search(Node root, int key) {
		if(root == null) {
			return false;
		}
		if(root.data == key) {
			return true;
		} else if(key < root.data) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}
}
