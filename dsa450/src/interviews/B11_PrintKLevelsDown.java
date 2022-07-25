package interviews;

/*
 * https://www.pepcoding.com/resources/online-java-foundation/binary-tree/print-k-levels-down-official/ojquestion
 * https://www.youtube.com/watch?v=KvcfuGcdDMg
 * Input :       1
               /   \
              2     3
             / \   /  \
            4   5  6   7

               k = 1

	Output : 2,3
	Printing is done in pre-order
 */
public class B11_PrintKLevelsDown {
	public static void main(String[] args) {
		B1_Node root = new B1_Node(1);
		root.left = new B1_Node(2);
		root.right = new B1_Node(3);
		root.left.left = new B1_Node(4);
		root.left.right = new B1_Node(5);
		root.right.left = new B1_Node(6);
		root.right.right = new B1_Node(7);
		int k = 1;
		printKLevelsDown(root, k);
	}

	private static void printKLevelsDown(B1_Node root, int k) {
		if (root == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(root.data);
		}
		printKLevelsDown(root.left, k - 1);
		printKLevelsDown(root.right, k - 1);
	}
}
