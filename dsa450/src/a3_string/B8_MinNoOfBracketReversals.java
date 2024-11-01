package a3_string;

import java.util.Stack;

/*
 * https://practice.geeksforgeeks.org/problems/count-the-reversals0401/1
 * https://www.youtube.com/watch?v=FB6wSdPjVGw
 * Given a string S consisting of only opening and closing curly brackets '{' and '}', find out the minimum number of reversals 
 * required to convert the string into a balanced expression.
	A reversal means changing '{' to '}' or vice-versa.
	Example 1:
	Input:
	S = "}{{}}{{{"
	Output: 3
	Explanation: One way to balance is:"{{{}}{}}". There is no balanced sequence that can be formed in lesser reversals.
 */
public class B8_MinNoOfBracketReversals {
	public static void main(String[] args) {
		String str = "}{{}}{{{";
		int rev = getReverseCounts(str);
		System.out.println(rev);
	}

	private static int getReverseCounts(String s) {
		if ((s.length() % 2) != 0)
			return -1;
		Stack<Character> st = new Stack<>();
		int ob = 0;
		int cb = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '{')
				st.push(ch);
			else {
				if (!st.isEmpty() && st.peek() == '{')
					st.pop();
				else
					st.push(ch);
			}
		}
		while (!st.isEmpty()) {
			char top = st.pop();
			if (top == '{')
				ob++;
			else
				cb++;
		}
		return (int) (Math.ceil(ob / 2.0) + Math.ceil(cb / 2.0));
	}
}
