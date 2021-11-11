package dsa_codewithharry;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class D_MultipleParanthesis {

	public static void main(String[] args) {
		// Stack<Character> stack = new Stack<>(); // Stack is synchronized and hence slower
		//String str = "(7-11+{23-8}-[33+1])";
		Deque<Character> stack = new ArrayDeque<>();
		System.out.println("Enter expression =");
		Scanner ob = new Scanner(System.in);
		String str = ob.next();
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}
			if (ch == ')') {
				if (stack.isEmpty()) {
					flag = 1;
					break;
				}
				char popped = stack.pop();
				if(popped != '(') {
					flag = 1;
					break;
				}
			}
			if (ch == ']') {
				if (stack.isEmpty()) {
					flag = 1;
					break;
				}
				char popped = stack.pop();
				if(popped != '[') {
					flag = 1;
					break;
				}
			}
			if (ch == '}') {
				if (stack.isEmpty()) {
					flag = 1;
					break;
				}
				char popped = stack.pop();
				if(popped != '{') {
					flag = 1;
					break;
				}
			}
		}
		if (!stack.isEmpty() || flag == 1) {
			System.out.println("Unbalanced Expr.");
		} else {
			System.out.println("Balanced Expr.");
		}
		ob.close();
	}
}
