package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
 * https://www.youtube.com/watch?v=SXKAD2svfmI
 *  			5
 * 			  /   \
 * 			 3     6
 * 		    / \     \
 * 		   2   4     7
 */
public class A4_PredAndSucc {
	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(6);
		root.left.left = new Node(2);
		root.left.right = new Node(4);
		root.right.right = new Node(7);
		Node pre = getPre(root, 5);
		System.out.println(pre.data);
		Node succ = getSucc(root, 5);
		System.out.println(succ.data);
	}

	private static Node getSucc(Node root, int key) {
		Node succ = null;
		while (root != null) {
			if (key >= root.data)
				root = root.right;
			else {
				succ = root;
				root = root.left;
			}
		}
		return succ;
	}

	private static Node getPre(Node root, int key) {
		Node pre = null;
		while (root != null) {
			if (key <= root.data)
				root = root.left;
			else {
				pre = root;
				root = root.right;
			}
		}
		return pre;
	}
}
