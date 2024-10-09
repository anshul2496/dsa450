package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/parenthesis-checker2744/1
 */
public class A4_BalancedParanth {
	public static void main(String[] args) {

	}

	static boolean ispar(String x) {
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < x.length(); i++) {
			Character ch = x.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[')
				st.push(ch);
			else if (ch == ')' && !st.isEmpty()) {
				if (st.peek() == '(')
					st.pop();
				else
					return false;
			} else if (ch == '}' && !st.isEmpty()) {
				if (st.peek() == '{')
					st.pop();
				else
					return false;
			} else if (ch == ']' && !st.isEmpty()) {
				if (st.peek() == '[')
					st.pop();
				else
					return false;
			} else
				return false;
		}

		return st.isEmpty();
	}
}
