package dsa_codewithharry;

public class F_QueueImplWithArray {

	public static void main(String[] args) {
		QueueWithArray queueWithArray = new QueueWithArray(5);
		queueWithArray.enqueue(25);
		queueWithArray.enqueue(40);
		queueWithArray.enqueue(52);
		queueWithArray.dequeue();
		queueWithArray.enqueue(26);
		queueWithArray.enqueue(27);
		queueWithArray.enqueue(28);
		System.out.println("isEmpty = " + queueWithArray.isEmpty());
		System.out.println("isFull = " + queueWithArray.isFull());
		System.out.println("front = " + queueWithArray.front());
		System.out.println("rear = " + queueWithArray.rear());
		queueWithArray.print();
	}
}

class QueueWithArray {
	int front, rear, size;
	int[] arr;

	public QueueWithArray(int size) {
		this.front = -1;
		this.rear = -1;
		this.size = size;
		arr = new int[size];
	}

	public boolean isFull() {
		return rear == size - 1;
	}

	public boolean isEmpty() {
		return front == rear;
	}

	public int front() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[front + 1];
		}
	}

	public int rear() {
		if (isEmpty()) {
			return -1;
		} else {
			return arr[rear];
		}
	}

	public void enqueue(int element) {
		if (isFull()) {
			System.out.println("Queue full");
			return;
		}
		arr[++rear] = element;
		System.out.println("Enqueued " + element);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue empty");
			return Integer.MIN_VALUE;
		}
		System.out.println("**Dequeued " + arr[++front]);
		return arr[front];
	}

	public void print() {
		for (int i = front + 1; i <= rear; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
