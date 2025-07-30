package b5_lld_pubsub.publisher;

import b5_lld_pubsub.Broker;
import b5_lld_pubsub.Message;

public class SimplePublisher implements IPublisher {
	private final String id;
	private final Broker broker;

	public SimplePublisher(String id, Broker broker) {
		this.id = id;
		this.broker = broker;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void publish(String topicId, Message message) throws IllegalArgumentException {
		broker.publish(this, topicId, message);
		System.out.println("Publisher " + id + " published: " + message.getMessage() + " to topic " + topicId);
	}
}