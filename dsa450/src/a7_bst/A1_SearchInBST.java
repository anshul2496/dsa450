package a7_bst;

/*
 * https://practice.geeksforgeeks.org/problems/search-a-node-in-bst/1
 * Input:    6
             \ 
              8 
             / \ 
            7   9
 */
public class A1_SearchInBST {
	public static void main(String[] args) {
		Node root = new Node(6);
		root.right = new Node(8);
		root.right.left = new Node(7);
		root.right.right = new Node(9);
		boolean found = search(root, 11);
		System.out.println(found);
	}

	private static boolean search(Node root, int key) {
		if (root == null)
			return false;
		if (root.data == key)
			return true;
		else if (key < root.data)
			return search(root.left, key);
		else
			return search(root.right, key);
	}
}

class Node {
	int data;
	Node right, left;

	public Node(int data) {
		this.data = data;
	}
}