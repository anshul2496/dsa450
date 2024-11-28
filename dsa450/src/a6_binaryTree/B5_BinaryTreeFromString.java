package a6_binaryTree;

/*
 * https://www.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/1
 * https://www.youtube.com/watch?v=BH_btihSwVM
 * Input : "4(2(3)(1))(6(5))"
	Output : 4 2 3 1 6 5
	Explanation :
	           4
	         /   \
	        2     6
	       / \   / 
	      3   1 5   
 */
public class B5_BinaryTreeFromString {
	private static int start = 0;

	public static void main(String[] args) {
		String str = "4(2(3)(1))(6(5))";
		TreeNode root = getBinaryTree(str);
		preOrder(root);
	}

	private static TreeNode getBinaryTree(String s) {
		if (start >= s.length())
			return null;
		boolean neg = false;
		if (s.charAt(start) == '-') {
			neg = true;
			start++;
		}
		int num = 0;
		while (start < s.length() && Character.isDigit(s.charAt(start))) {
			num = (num * 10) + Character.getNumericValue(s.charAt(start));
			start++;
		}
		if (neg)
			num = -num;

		TreeNode root = new TreeNode(num);
		if (start >= s.length())
			return root;
		if (start < s.length() && s.charAt(start) == '(') {
			start++;
			root.left = getBinaryTree(s);
		}
		if (start < s.length() && s.charAt(start) == ')') {
			start++;
			return root;
		}

		if (start < s.length() && s.charAt(start) == '(') {
			start++;
			root.right = getBinaryTree(s);
		}
		if (start < s.length() && s.charAt(start) == ')') {
			start++;
			return root;
		}
		return root;
	}

	private static void preOrder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
}
