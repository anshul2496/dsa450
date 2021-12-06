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
		Stack<Character> stack = new Stack<>();
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (ch == '{' || ch == '(' || ch == '[') {
				stack.push(ch);
			} else if (ch == ']') {
				if (!stack.isEmpty() && stack.peek() == '[')
					stack.pop();
				else {
					flag = false;
					break;
				}
			} else if (ch == ')') {
				if (!stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else {
					flag = false;
					break;
				}
			} else if (ch == '}') {
				if (!stack.isEmpty() && stack.peek() == '{')
					stack.pop();
				else {
					flag = false;
					break;
				}
			}
		}
		System.out.println(flag);
	}
}
