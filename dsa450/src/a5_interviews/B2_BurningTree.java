package a5_interviews;

/*
 * https://www.geeksforgeeks.org/burn-the-binary-tree-starting-from-the-target-node/
 * https://www.youtube.com/watch?v=dtBj2A_7JOk
 *  		12
           /  \
          13  10
              / \
             14 15
            / \ / \
          21 24 22 23
 */
public class B2_BurningTree {
	private static int maxTime = 0;

	public static void main(String[] args) {
		B1_Node root = new B1_Node(12);
		root.left = new B1_Node(13);
		root.right = new B1_Node(10);
		root.right.left = new B1_Node(14);
		root.right.right = new B1_Node(15);
		B1_Node left = root.right.left;
		B1_Node right = root.right.right;
		left.left = new B1_Node(21);
		left.right = new B1_Node(24);
		right.left = new B1_Node(22);
		right.right = new B1_Node(23);

		burningTree(root, 10);
		System.out.println(maxTime);
	}

	private static int burningTree(B1_Node root, int fireNode) {
		if (root == null)
			return -1;

		if (root.data == fireNode) {
			burnTree(root, null, 0);
			return 1;
		}
		int leftTime = burningTree(root.left, fireNode);
		if (leftTime != -1) {
			burnTree(root, root.left, leftTime);
			return leftTime + 1;
		}
		int rightTime = burningTree(root.right, fireNode);
		if (rightTime != -1) {
			burnTree(root, root.right, rightTime);
			return rightTime + 1;
		}
		return -1;
	}

	private static void burnTree(B1_Node root, B1_Node blockNode, int time) {
		if (root == null || root == blockNode) {
			return;
		}
		maxTime = Math.max(time, maxTime);
		burnTree(root.left, blockNode, time + 1);
		burnTree(root.right, blockNode, time + 1);
	}
}
