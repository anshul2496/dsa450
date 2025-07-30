package b5_lld_pubsub;

import b5_lld_pubsub.publisher.SimplePublisher;
import b5_lld_pubsub.subscriber.SimpleSubscriber;

/*
 * https://github.com/ashishps1/awesome-low-level-design/blob/main/solutions/java/src/pubsubsystem/subscriber/Subscriber.java
 * https://codewitharyan.com/tech-blogs/design-pub-sub-model-like-kafka
 * Code is taken from CodewithAryan
 */
public class Demo {
	public static void main(String[] args) {
		Broker broker = new Broker();
        // Create topics.
        Topic topic1 = broker.createTopic("Topic1");
        Topic topic2 = broker.createTopic("Topic2");

        // Create subscribers.
        SimpleSubscriber subscriber1 = new SimpleSubscriber("Subscriber1");
        SimpleSubscriber subscriber2 = new SimpleSubscriber("Subscriber2");
        SimpleSubscriber subscriber3 = new SimpleSubscriber("Subscriber3");
        // Subscribe: subscriber1 subscribes to both topics,
        // subscriber2 subscribes to topic1, and subscriber3 subscribes to topic2.
        broker.subscribe(subscriber1, topic1.getTopicId());
        broker.subscribe(subscriber1, topic2.getTopicId());
        broker.subscribe(subscriber2, topic1.getTopicId());
        broker.subscribe(subscriber3, topic2.getTopicId());
        // Create publishers.
        SimplePublisher publisher1 = new SimplePublisher("Publisher1", broker);
        SimplePublisher publisher2 = new SimplePublisher("Publisher2", broker);
        // Publish some messages.
        publisher1.publish(topic1.getTopicId(), new Message("Message m1"));
        publisher1.publish(topic1.getTopicId(), new Message("Message m2"));
        publisher2.publish(topic2.getTopicId(), new Message("Message m3"));

        // Allow time for subscribers to process messages.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        publisher2.publish(topic2.getTopicId(), new Message("Message m4"));
        publisher1.publish(topic1.getTopicId(), new Message("Message m5"));
        // Reset offset for subscriber1 on topic1 (for example, to re-process messages).
        broker.resetOffset(topic1.getTopicId(), subscriber1, 0);
        // Allow some time before shutting down.
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        broker.shutdown();
	}
}
