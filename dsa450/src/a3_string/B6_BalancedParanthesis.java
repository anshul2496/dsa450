package a3_string;

import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/parenthesis-checker2744/1
 * Given an expression string x. Examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
	For example, the function should return 'true' for exp = “[()]{}{[()()]()}” and 'false' for exp = “[(])”.
	Example 1:
	Input:
	{([])}
	Output: 
	true
 */
public class B6_BalancedParanthesis {
	public static void main(String[] args) {
		String str = "{([])}";
		System.out.println(ispar(str));
	}

	static boolean ispar(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[')
				stack.push(ch);
			else if (ch == ']') {
				if (stack.isEmpty() || stack.peek() != '[')
					return false;
				stack.pop();
			} else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() != '(')
					return false;
				stack.pop();
			} else if (ch == '}') {
				if (stack.isEmpty() || stack.peek() != '{')
					return false;
				stack.pop();
			}
		}
		return !stack.isEmpty() ? false : true;
	}
}
