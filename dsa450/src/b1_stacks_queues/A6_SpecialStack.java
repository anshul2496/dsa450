package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/special-stack/1
 * https://www.youtube.com/watch?v=OpwYmEBcPh0
 */
public class A6_SpecialStack {

}

class GfG {
	int min = Integer.MAX_VALUE;

	public void push(int a, Stack<Integer> s) {
		if (s.isEmpty()) {
			s.push(a);
			min = a;
		} else {
			if (a < min) {
				min = a;
				s.push(2 * a - min);
			} else {
				s.push(a);
			}
		}
	}

	public int pop(Stack<Integer> s) {
		if (s.isEmpty())
			return -1;
		if (min < s.peek())
			return s.pop();
		else {
			int prevMin = min;
			int val = 2 * min - s.peek();
			min = val;
			return prevMin;
		}
	}

	public int min(Stack<Integer> s) {
		if (s.isEmpty())
			return -1;
		return min;
	}

	public boolean isFull(Stack<Integer> s, int n) {
		return s.size() == n;
	}

	public boolean isEmpty(Stack<Integer> s) {
		return s.isEmpty();
	}
}
