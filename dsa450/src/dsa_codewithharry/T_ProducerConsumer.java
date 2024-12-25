package dsa_codewithharry;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

// https://javarevisited.blogspot.com/2012/02/producer-consumer-design-pattern-with.html#google_vignette
public class T_ProducerConsumer {
	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();

		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));

		producer.start();
		consumer.start();
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