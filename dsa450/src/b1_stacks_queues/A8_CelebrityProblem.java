package b1_stacks_queues;

import java.util.Stack;

/*
 * https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
 * https://www.youtube.com/watch?v=CiiXBvrX-5A
 */
public class A8_CelebrityProblem {
	public static void main(String[] args) {

	}

	public int celebrity(int mat[][]) {
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < mat.length; i++) {
			st.push(i);
		}
		while (st.size() >= 2) {
			int i = st.pop();
			int j = st.pop();
			if (mat[i][j] == 1) {
				// If i knows j -> i is not celeb
				st.push(j);
			} else if (mat[j][i] == 1) {
				// If j knows i -> j is not a celeb
				st.push(i);
			}
		}
		int pot = st.pop();
		for (int i = 0; i < mat.length; i++) {
			if (i != pot) {
				if (mat[i][pot] == 0 || mat[pot][i] == 1)
					return -1;
			}
		}
		return pot;
	}
}
