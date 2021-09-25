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

	Node root;
	Node prev;
	public static void main(String[] args) {
		P_isBST ob = new P_isBST();
		// Creating Nodes
		ob.root = new Node(7);
		ob.root.left = new Node(2);
		ob.root.right = new Node(9);
		ob.root.left.left = new Node(0);
		ob.root.left.right = new Node(4);

		// Input tree -
		//       7
		//      /  \
		//     2    9
		//    / \
		//   0   4
		
		System.out.println("isBST = " + ob.isBST());
	}

	private boolean isBST() {
		prev = null;
		return isBST(root);
	}

	private boolean isBST(Node node) {
		if(node != null) {
			if(!isBST(node.left)) {
				return false;
			}
			if (prev != null && prev.data >= node.data) {
				return false;
			}
			prev = node;
			return isBST(node.right);
		}
		return true;
	}

}
