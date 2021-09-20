package dsa_codewithharry;

public class B_ImplStackWithList {
	public static void main(String[] args) {
		StackWithList stack = new StackWithList();
		stack.push(2);
		stack.push(5);
		stack.push(9);
		stack.display();
		System.out.println("isEmpty = " + stack.isEmpty());
		System.out.println("pop = " + stack.pop());
		stack.display();
		System.out.println("peek = " + stack.peek());
		stack.pop();
		stack.pop();
		System.out.println("isEmpty = " + stack.isEmpty());
		stack.pop();
	}
}

class StackWithList {

	class StackNode {
		int data;
		StackNode next;

		public StackNode(int data) {
			this.data = data;
		}
	}

	StackNode root;

	boolean isEmpty() {
		return root == null;
	}

	void push(int element) {
		StackNode temp = new StackNode(element);
		if (root == null) {
			root = temp;
		} else {
			temp.next = root;
			root = temp;
		}
	}

	int pop() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		int data = root.data;
		root = root.next;
		return data;
	}

	int peek() {
		if (isEmpty()) {
			System.out.println("Stack Underflow");
			return Integer.MIN_VALUE;
		}
		return root.data;
	}

	void display() {
		StackNode temp = root;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}
