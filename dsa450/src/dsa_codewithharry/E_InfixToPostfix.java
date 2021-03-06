package dsa_codewithharry;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class E_InfixToPostfix {

	private static Map<Character, Integer> map = new HashMap<>();
	static {
		map.put('(', -1);
		map.put(')', -1);
		map.put('+', 1);
		map.put('-', 1);
		map.put('*', 2);
		map.put('/', 2);
	}

	public static void main(String[] args) {
		String str = "(p-q)-(r/a)";
		String postfix = convertInfixToPostfix(str);
		System.out.println("Postfix expression = " + postfix);
	}

	private static String convertInfixToPostfix(String infix) {
		String postfix = "";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
			Character ch = infix.charAt(i);
			if (Character.isLetterOrDigit(ch)) {
				postfix = postfix + ch;
			} else if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				while (!stack.isEmpty() && stack.peek() != '(') {
					postfix = postfix + stack.pop();
				}
				stack.pop(); // To pop out (
			} else {
				while (!stack.isEmpty() && map.get(ch) <= map.get(stack.peek())) {
					postfix = postfix + stack.pop();
				}
				stack.push(ch);
			}
		}
		// Pop out all remaining operators in stack
		while (!stack.isEmpty()) {
			postfix = postfix + stack.pop();
		}
		return postfix;
	}
}
