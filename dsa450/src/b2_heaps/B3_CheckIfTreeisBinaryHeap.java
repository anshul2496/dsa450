package b2_heaps;

/*
 * https://www.geeksforgeeks.org/problems/is-binary-tree-heap/1
 * https://www.youtube.com/watch?v=_9F2VgZcvdw
 */
public class B3_CheckIfTreeisBinaryHeap {
	public static void main(String[] args) {

	}

	boolean isHeap(Nodee root) {
		int count = getTotalNodeCount(root);
		return isCBT(root, 0, count) && isMaxOrder(root);
	}

	int getTotalNodeCount(Nodee root) {
		if (root == null)
			return 0;
		int ans = 1 + getTotalNodeCount(root.left) + getTotalNodeCount(root.right);
		return ans;
	}

	boolean isCBT(Nodee root, int index, int count) {
		if (root == null)
			return true;
		if (index >= count)
			return false;
		else {
			boolean left = isCBT(root.left, 2 * index + 1, count);
			boolean right = isCBT(root.right, 2 * index + 2, count);
			return (left && right);
		}
	}

	boolean isMaxOrder(Nodee root) {
		// Condition 1 - Leaf node
		if (root.left == null && root.right == null)
			return true;
		// Condition 2- Only left child exists
		if (root.right == null)
			return root.data > root.left.data;
		else {
			// Condition 3- Both child exists
			return ((root.data > root.right.data) && (root.data > root.left.data) && isMaxOrder(root.left)
					&& isMaxOrder(root.right));
		}
	}
}

class Nodee {
	int data;
	Nodee left, right;

	Nodee(int d) {
		data = d;
		left = right = null;
	}
}
