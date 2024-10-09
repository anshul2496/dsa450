package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1
 * https://www.geeksforgeeks.org/delete-middle-element-stack/
 */
public class A2_DeleteMidOfStack {
	public static void main(String[] args) {

	}

	public void deleteMid(Stack<Integer> s, int sizeOfStack) {
		Stack<Integer> st = new Stack<>();
		int mid = (int) Math.floor((sizeOfStack + 1) / 2);
		if (sizeOfStack == mid) {
			s.pop();
			return;
		}
		while (s.size() > mid)
			st.push(s.pop());
		s.pop();
		while (!st.isEmpty())
			s.push(st.pop());
	}
}
