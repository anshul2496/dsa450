package a9_backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/remove-invalid-parentheses/description/
 * https://www.youtube.com/watch?v=Cbbf5qe5stw
 */
public class A4_RemoveInvalidParanthesis {
	public static void main(String[] args) {
		System.out.println(removeInvalidParentheses("()())()"));
	}

	public static List<String> removeInvalidParentheses(String s) {
		List<String> ans = new ArrayList<>();
		int mra = getMin(s);
		HashSet<String> set = new HashSet<>();
		solve(s, mra, ans, set);
		return ans;
	}

	public static void solve(String s, int mra, List<String> ans, HashSet<String> set) {
		if (mra == 0) {
			int valid = getMin(s);
			if (valid == 0) {
				if (!ans.contains(s))
					ans.add(s);
			}
		}
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0, i);
			String right = s.substring(i + 1);
			if (!set.contains(left + right)) {
				set.add(left + right);
				solve(left + right, mra - 1, ans, set);
			}
		}
	}

	public static int getMin(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (c == '(')
				stack.push(c);
			else if (c == ')' && stack.isEmpty())
				stack.push(c);
			else if (c == ')' && stack.peek() == '(')
				stack.pop();
			else if (c == ')' && stack.peek() == ')')
				stack.push(c);
		}
		return stack.size();
	}
}
