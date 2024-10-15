package b1_stacks_queues;

/*
 * https://www.naukri.com/code360/problems/n-stacks-in-an-array_1164271?leftPanelTabValue=PROBLEM
 * https://www.youtube.com/watch?v=lrSXKLmnMV8
 */
public class A3_NStacksInArray {
	public static void main(String[] args) {

	}
}

class NStack {
	int[] arr;
	int[] top;
	int[] next;
	int freespot;
	int n, s;

	public NStack(int N, int S) {
		n = N;
		s = S;
		arr = new int[s];
		next = new int[s];
		top = new int[n];
		// initialize top
		for (int i = 0; i < n; i++)
			top[i] = -1;
		// initialize next
		for (int i = 0; i < s; i++)
			next[i] = i + 1;
		// update last index value to -1
		next[s - 1] = -1;
		// initialize freespot
		freespot = 0;
	}

	// Pushes 'X' into the Mth stack. Returns true if it gets pushed into the stack,
	// and false otherwise.
	public boolean push(int x, int m) {
		// check for overflow
		if (freespot == -1)
			return false;
		// find index
		int index = freespot;
		// insert element in array
		arr[index] = x;
		// update freespot
		freespot = next[index];
		// update next
		next[index] = top[m - 1];
		// update top
		top[m - 1] = index;
		return true;
	}

	// Pops top element from Mth Stack. Returns -1 if the stack is empty, otherwise
	// returns the popped element.
	public int pop(int m) {
		// check underflow
		if (top[m - 1] == -1)
			return -1;
		int index = top[m - 1];
		top[m - 1] = next[index];
		next[index] = freespot;
		freespot = index;
		return arr[index];
	}
}