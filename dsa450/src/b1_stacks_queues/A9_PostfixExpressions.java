package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 * https://www.youtube.com/watch?v=BlNXOtll7jo
 */
public class A9_PostfixExpressions {
	public static void main(String[] args) {

	}

	public static int evaluatePostFix(String s) {
		Stack<Integer> vs = new Stack<>();
		Stack<String> is = new Stack<>();
		Stack<String> ps = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				// Value Stack
				int v2 = vs.pop();
				int v1 = vs.pop();
				int val = process(v1, v2, ch);
				vs.push(val);

				// Infix Stack
				String iv2 = is.pop();
				String iv1 = is.pop();
				String ival = "(" + iv1 + ch + iv2 + ")";
				is.push(ival);

				// Prefix Stack
				String pv2 = ps.pop();
				String pv1 = ps.pop();
				String pval = ch + pv1 + pv2;
				ps.push(pval);
			} else {
				vs.push(ch - '0'); // Make character to Integer
				is.push(ch + "");
				ps.push(ch + "");
			}
		}
		return vs.pop();
	}

	public static int process(int v1, int v2, char ch) {
		if (ch == '+') {
			return v1 + v2;
		} else if (ch == '-') {
			return v1 - v2;
		} else if (ch == '*') {
			return v1 * v2;
		} else if (ch == '/') {
			return v1 / v2;
		}
		return 0;
	}
}
