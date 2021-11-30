package misc;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		Thread t1 = new Thread(new Producer(queue));
		Thread t2 = new Thread(new Consumer(queue));

		t1.start();
		t2.start();
	}
}

class Producer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++) {
				System.out.println(i + " pushing in queue");
				queue.put(i);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Consumer implements Runnable {

	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			for (int i = 1; i <= 10; i++)
				System.out.println(queue.take() + " consumed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}