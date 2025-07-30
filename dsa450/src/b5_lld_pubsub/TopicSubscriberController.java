package b5_lld_pubsub;

import b5_lld_pubsub.subscriber.ISubscriber;

public class TopicSubscriberController implements Runnable {
	private final TopicSubscriber topicSubscriber;

	public TopicSubscriberController(TopicSubscriber topicSubscriber) {
		this.topicSubscriber = topicSubscriber;
	}

	@Override
	public void run() {
		Topic topic = topicSubscriber.getTopic();
		ISubscriber subscriber = topicSubscriber.getSubscriber();
		while (true) {
			Message messageToProcess = null;

			synchronized (topicSubscriber) {
				// Wait until there is a new message (offset is less than the number of
				// messages)
				while (topicSubscriber.getOffset().get() >= topic.getMessages().size()) {
					try {
						topicSubscriber.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						return;
					}
				}
				// Retrieve the next message and increment the offset
				int currentOffset = topicSubscriber.getOffset().getAndIncrement();
				messageToProcess = topic.getMessages().get(currentOffset);
			}
			// Process the message outside of the synchronized block & this processing can
			// also be done in parallel in some other threads
			try {
				subscriber.onMessage(messageToProcess);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
}