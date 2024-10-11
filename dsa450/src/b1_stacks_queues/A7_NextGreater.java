package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 * https://www.youtube.com/watch?v=rSf9vPtKcmI
 */
public class A7_NextGreater {
	public static void main(String[] args) {

	}

	public static long[] nextLargerElement(long[] arr, int n) {
		long[] ans = new long[n];
		ans[n - 1] = -1;
		Stack<Long> st = new Stack<>();
		st.push(arr[n - 1]);
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && arr[i] >= st.peek())
				st.pop();
			if (st.isEmpty())
				ans[i] = -1;
			else
				ans[i] = st.peek();
			st.push(arr[i]);
		}
		return ans;
	}
}
