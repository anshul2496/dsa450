package dsa_codewithharry;

public class A_ImplStackWithArray {

	public static void main(String[] args) {
		StackWithArray stack = new StackWithArray();
		stack.push(2);
		stack.push(5);
		stack.push(9);
		stack.display();
		System.out.println("isEmpty = " + stack.isEmpty());
		System.out.println("pop = " + stack.pop());
		stack.display();
		System.out.println("isFull = " + stack.isFull());
		System.out.println("peek = " + stack.peek());
		stack.pop();
		stack.pop();
		System.out.println("isEmpty = " + stack.isEmpty());
		stack.pop();
	}
}

class StackWithArray {
	int top = -1;
	int MAX_SIZE = 3;
	int[] a = new int[MAX_SIZE];

	boolean isEmpty() {
		return top == -1;
	}

	boolean isFull() {
		return top == MAX_SIZE - 1;
	}

	boolean push(int element) {
		if (isFull()) {
			System.out.println("Stack Overflow");
			return false;
		}
		a[++top] = element;
		return true;
	}

	int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return a[top--];
	}

	int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		if (isFull()) {
			System.out.println("Stack Overflow");
			return Integer.MAX_VALUE;
		}
		return a[top];
	}

	void display() {
		for (int i = top; i >= 0; i--) {
			System.out.println(a[i]);
		}
	}
}
