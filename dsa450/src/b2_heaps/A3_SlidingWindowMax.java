package b2_heaps;

import java.util.ArrayList;
import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 * https://www.youtube.com/watch?v=tCVOQX3lWeI
 */
public class A3_SlidingWindowMax {
	public static void main(String[] args) {

	}

	public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
		ArrayList<Integer> ans = new ArrayList<>();
		int n = arr.length;
		int[] nge = new int[n];
		Stack<Integer> st = new Stack<>();
		nge[n - 1] = n;
		st.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!st.isEmpty() && arr[i] >= arr[st.peek()])
				st.pop();
			if (st.isEmpty())
				nge[i] = n;
			else
				nge[i] = st.peek();
			st.push(i);
		}
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (j < i)
				j = i;
			while (nge[j] < i + k)
				j = nge[j];
			ans.add(arr[j]);
		}
		return ans;
	}
}
