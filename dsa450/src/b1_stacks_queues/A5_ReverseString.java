package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
 */
public class A5_ReverseString {
	public static void main(String[] args) {

	}

	public String reverse(String s) {
		String ans = "";
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++)
			st.push(s.charAt(i));
		while (!st.isEmpty())
			ans += st.pop();
		return ans;
	}
}
