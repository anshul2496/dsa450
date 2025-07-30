package b5_lld_pubsub;

import java.util.concurrent.atomic.AtomicInteger;

import b5_lld_pubsub.subscriber.ISubscriber;

public class TopicSubscriber {
	private final Topic topic;
	private final ISubscriber subscriber;
	private final AtomicInteger offset;

	public TopicSubscriber(Topic topic, ISubscriber subscriber) {
		this.topic = topic;
		this.subscriber = subscriber;
		this.offset = new AtomicInteger(0);
	}

	public Topic getTopic() {
		return topic;
	}

	public ISubscriber getSubscriber() {
		return subscriber;
	}

	public AtomicInteger getOffset() {
		return offset;
	}
}