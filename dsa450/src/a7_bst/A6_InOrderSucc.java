package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/populate-inorder-successor-for-all-nodes/1
 * https://www.youtube.com/watch?v=W25l6evkk_U
 *   		    5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A6_InOrderSucc {
	static A6Node prev = null;

	public static void main(String[] args) {
		A6Node root = new A6Node(5);
		root.left = new A6Node(3);
		root.right = new A6Node(6);
		root.left.left = new A6Node(2);
		root.left.right = new A6Node(4);
		root.right.right = new A6Node(7);
		inOrderSucc(root);
		print(root);
	}

	private static void print(A6Node root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.data + "->" + (root.next == null ? -1 : root.next.data));
			print(root.right);
		}
	}

	private static void inOrderSucc(A6Node root) {
		if (root != null) {
			inOrderSucc(root.left);
			if (prev != null)
				prev.next = root;
			prev = root;
			inOrderSucc(root.right);
		}
	}
}

class A6Node {
	int data;
	A6Node right, left, next;

	public A6Node(int data) {
		this.data = data;
	}
}