package dsa_codewithharry;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class C_ParanthesisMatching {
	public static void main(String[] args) {
		//Stack<Character> stack = new Stack<>(); // Stack is synchronized and hence slower
		Deque<Character> stack = new ArrayDeque<>();
		System.out.println("Enter expression =");
		Scanner ob = new Scanner(System.in);
		String str = ob.next();
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(') {
				stack.push('(');
			}
			if (ch == ')') {
				if (stack.isEmpty()) {
					flag = 1;
					break;
				}
				stack.pop();
			}
		}
		if (!stack.isEmpty() || flag == 1) {
			System.out.println("Unbalanced Expr.");
		} else {
			System.out.println("Balanced Expr.");
		}
	}
}
