package dsa_codewithharry;

public class H_QueueWithList {

	public static void main(String[] args) {
		QueueWithList queueWithList = new QueueWithList();
		System.out.println("isEmpty = " + queueWithList.isEmpty());
		queueWithList.enqueue(25);
		queueWithList.enqueue(40);
		queueWithList.enqueue(52);
		queueWithList.enqueue(26);
		queueWithList.enqueue(28);
		queueWithList.dequeue();
		queueWithList.enqueue(27);
		System.out.println("front = " + queueWithList.getFrontElement());
		System.out.println("rear = " + queueWithList.getRearElement());
		queueWithList.print();
	}
}

class QueueWithList {

	QueueNode front;
	QueueNode rear;

	class QueueNode {
		int data;
		QueueNode next;

		public QueueNode(int data) {
			this.data = data;
		}
	}

	public boolean isEmpty() {
		return front == null;
	}

	public void print() {
		while (front != null) {
			System.out.print(front.data + " ");
			front = front.next;
		}
	}

	public int getFrontElement() {
		if (isEmpty()) {
			return -1;
		}
		return front.data;
	}

	public int getRearElement() {
		if (isEmpty()) {
			return -1;
		}
		return rear.data;
	}

	public void enqueue(int element) {
		QueueNode newNode = new QueueNode(element);
		if (isEmpty()) {
			front = rear = newNode;
		} else {
			rear.next = newNode;
			rear = newNode;
		}
		System.out.println("Enqueued " + element);
	}

	public void dequeue() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			System.out.println("**Dequeued " + front.data);
			front = front.next;
		}
	}
}
