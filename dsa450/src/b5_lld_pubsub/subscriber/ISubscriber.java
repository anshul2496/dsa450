package b5_lld_pubsub.subscriber;

import b5_lld_pubsub.Message;

public interface ISubscriber {
	String getId();

	void onMessage(Message message) throws InterruptedException;
}