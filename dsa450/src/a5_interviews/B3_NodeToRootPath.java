package a5_interviews;

import java.util.ArrayList;
import java.util.Collections;

/*
 * https://www.geeksforgeeks.org/print-path-root-given-node-binary-tree/
 * https://www.youtube.com/watch?v=1Kyc-zQS7eQ
 * Input :       1
               /   \
              2     3
             / \   /  \
            4   5  6   7

               x = 5

	Output : 1->2->5
 */
public class B3_NodeToRootPath {
	private static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) {
		B1_Node root = new B1_Node(1);
		root.left = new B1_Node(2);
		root.right = new B1_Node(3);
		root.left.left = new B1_Node(4);
		root.left.right = new B1_Node(5);
		root.right.left = new B1_Node(6);
		root.right.right = new B1_Node(7);
		int x = 5;
		find(root, x);
		Collections.reverse(list);
		System.out.println(list);
	}

	private static boolean find(B1_Node root, int data) {
		if (root == null)
			return false;

		if (root.data == data) {
			list.add(root.data);
			return true;
		}

		boolean left = find(root.left, data);
		if (left) {
			list.add(root.data);
			return true;
		}

		boolean right = find(root.right, data);
		if (right) {
			list.add(root.data);
			return true;
		}

		return false;
	}
}
