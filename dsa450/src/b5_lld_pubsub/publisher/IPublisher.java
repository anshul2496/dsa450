package b5_lld_pubsub.publisher;

import b5_lld_pubsub.Message;

public interface IPublisher {
	String getId();

	void publish(String topicId, Message message) throws IllegalArgumentException;
}