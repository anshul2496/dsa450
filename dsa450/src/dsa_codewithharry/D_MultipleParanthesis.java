package dsa_codewithharry;

import java.util.Stack;

public class D_MultipleParanthesis {

	public static void main(String[] args) {
		String str = "(7-11+{23-8}-[33+1])";
		Stack<Character> stack = new Stack<>();
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[')
				stack.push(ch);
			else if (ch == ')') {
				if (stack.isEmpty() || stack.peek() != '(') {
					flag = 1;
					break;
				}
				stack.pop();
			} else if (ch == '}') {
				if (stack.isEmpty() || stack.peek() != '{') {
					flag = 1;
					break;
				}
				stack.pop();
			} else if (ch == ']') {
				if (stack.isEmpty() || stack.peek() != '[') {
					flag = 1;
					break;
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty() || flag == 1)
			System.out.println("Not balanced");
		else
			System.out.println("Balanced");
	}
}
