package interviews;

import java.util.ArrayList;
import java.util.LinkedList;

/*
 * https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1/
 * https://www.youtube.com/watch?v=fcmxvpwFHgk
 * Given a Binary Tree, print Right view of it. Right view of a Binary Tree is set of nodes visible when tree is visited from Right side. 
	Right view of following tree is 1 3 7 8

          1
       /     \
     2        3
   /   \     /  \
  4     5   6    7
                  \
                   8
 */
public class B5_RightViewOfTree {
	public static void main(String[] args) {
		B1_Node root = new B1_Node(1);
		root.left = new B1_Node(2);
		root.right = new B1_Node(3);
		root.left.left = new B1_Node(4);
		root.left.right = new B1_Node(5);
		root.right.left = new B1_Node(6);
		root.right.right = new B1_Node(7);
		root.right.left.right = new B1_Node(8);
		ArrayList<Integer> list = rightView(root);
		System.out.println(list);
	}

	private static ArrayList<Integer> rightView(B1_Node root) {
		if (root == null)
			return new ArrayList<>();
		ArrayList<Integer> list = new ArrayList<>();
		LinkedList<B1_Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			list.add(queue.getFirst().data);
			while (size-- > 0) {
				B1_Node removedNode = queue.removeFirst();
				if (removedNode.right != null)
					queue.addLast(removedNode.right);
				if (removedNode.left != null)
					queue.addLast(removedNode.left);
			}
		}

		return list;
	}
}
