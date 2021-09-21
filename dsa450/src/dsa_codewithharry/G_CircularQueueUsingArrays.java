package dsa_codewithharry;

public class G_CircularQueueUsingArrays {

	public static void main(String[] args) {
		CircularQueueUsingArrays queueWithArray = new CircularQueueUsingArrays(5);
		queueWithArray.enqueue(25);
		queueWithArray.enqueue(40);
		queueWithArray.enqueue(52);
		queueWithArray.enqueue(26);
		queueWithArray.enqueue(28);
		System.out.println("isFull = " + queueWithArray.isFull());
		queueWithArray.dequeue();
		queueWithArray.enqueue(27);
		System.out.println("isEmpty = " + queueWithArray.isEmpty());
		System.out.println("front = " + queueWithArray.front());
		System.out.println("rear = " + queueWithArray.rear());
	}
}

// Only difference between queue and circular queue is circular increment
class CircularQueueUsingArrays {
	int front, rear, size;
	int[] arr;

	public CircularQueueUsingArrays(int size) {
		this.front = 0;
		this.rear = 0;
		this.size = size;
		arr = new int[size];
	}

	public boolean isFull() {
		return ((rear + 1) % size) == front;
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
		rear = (rear + 1) % size;
		arr[rear] = element;
		System.out.println("Enqueued " + element);
	}

	public int dequeue() {
		if (isEmpty()) {
			System.out.println("Queue empty");
			return Integer.MIN_VALUE;
		}
		front = (front + 1) % size;
		System.out.println("Dequeued " + arr[front]);
		return arr[front];
	}
}
