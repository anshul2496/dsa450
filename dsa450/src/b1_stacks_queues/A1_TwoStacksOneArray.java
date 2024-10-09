package b1_stacks_queues;

/*
 * https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
 * https://www.youtube.com/watch?v=S4mBBDfvWCE
 */
public class A1_TwoStacksOneArray {
	public static void main(String[] args) {
		TwoStacks ob = new TwoStacks();
		ob.push1(2);
		ob.push2(5);
		System.out.println(ob.pop1());
	}
}

class TwoStacks {
	int top1;
	int top2;
	int size = 3000;
	int[] arr;

	TwoStacks() {
		top1 = -1;
		top2 = size;
		arr = new int[size];
	}

	// Function to push an integer into the stack1.
	void push1(int x) {
		if (top1 == top2 - 1) {
			return;
		}
		arr[++top1] = x;
	}

	// Function to push an integer into the stack2.
	void push2(int x) {
		if (top1 == top2 - 1) {
			return;
		}
		arr[--top2] = x;
	}

	// Function to remove an element from top of the stack1.
	int pop1() {
		if (top1 == -1)
			return -1;
		return arr[top1--];
	}

	// Function to remove an element from top of the stack2.
	int pop2() {
		if (top2 == size)
			return -1;
		return arr[top2++];
	}
}
