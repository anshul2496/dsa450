package b5_lld_pubsub;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import b5_lld_pubsub.publisher.IPublisher;
import b5_lld_pubsub.subscriber.ISubscriber;

public class Broker {
	// Map of topic IDs to Topic objects.
	private final Map<String, Topic> topics;
	// Map of topic IDs to their list of TopicSubscriber associations.
	private final Map<String, List<TopicSubscriber>> topicSubscribers;
	// ExecutorService to run subscriber tasks concurrently.
	private final ExecutorService subscriberExecutor;
	private final AtomicInteger topicIdCounter;

	public Broker() {
		topics = new ConcurrentHashMap<>();
		topicSubscribers = new ConcurrentHashMap<>();
		// Using a cached thread pool to dynamically manage threads.
		subscriberExecutor = Executors.newCachedThreadPool();
		topicIdCounter = new AtomicInteger(0);
	}

	public Topic createTopic(String topicName) {
 		String topicId = String.valueOf(topicIdCounter.incrementAndGet());
		Topic topic = new Topic(topicName, topicId);
		topics.put(topicId, topic);
		topicSubscribers.put(topicId, new CopyOnWriteArrayList<>());
		System.out.println("Created topic: " + topicName + " with id: " + topicId);
		return topic;
	}

	public void subscribe(ISubscriber subscriber, String topicId) {
		Topic topic = topics.get(topicId);
		if (topic == null) {
			System.err.println("Topic with id " + topicId + " does not exist");
			return;
		}
		TopicSubscriber ts = new TopicSubscriber(topic, subscriber);
		topicSubscribers.get(topicId).add(ts);
		// Submit the subscriber task to the executor.
		subscriberExecutor.submit(new TopicSubscriberController(ts));
		System.out.println("Subscriber " + subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
	}

	public void publish(IPublisher publisher, String topicId, Message message) {
		Topic topic = topics.get(topicId);
		if (topic == null) {
			throw new IllegalArgumentException("Topic with id " + topicId + " does not exist");
		}
		topic.addMessage(message);
		// wake up each subscriber on its own monitor
		List<TopicSubscriber> subs = topicSubscribers.get(topicId);
		for (TopicSubscriber topicSubscriber : subs) {
			synchronized (topicSubscriber) {
				topicSubscriber.notify();
			}
		}
		System.out.println("Message " + message.getMessage() + " published to topic: " + topic.getTopicName());
	}

	// Resets the offset for the given subscriber on the specified topic.
	public void resetOffset(String topicId, ISubscriber subscriber, int newOffset) {
		List<TopicSubscriber> subscribers = topicSubscribers.get(topicId);
		if (subscribers == null) {
			System.err.println("Topic with id " + topicId + " does not exist");
			return;
		}
		for (TopicSubscriber ts : subscribers) {
			if (ts.getSubscriber().getId().equals(subscriber.getId())) {
				ts.getOffset().set(newOffset);
				// Notify in case the subscriber thread is waiting.
				synchronized (ts) {
					ts.notify();
				}
				System.out.println("Offset for subscriber " + subscriber.getId() + " on topic "
						+ ts.getTopic().getTopicName() + " reset to " + newOffset);
				break;
			}
		}
	}

	// Shutdown the ExecutorService gracefully.
	public void shutdown() {
		subscriberExecutor.shutdown();
		try {
			if (!subscriberExecutor.awaitTermination(5, TimeUnit.SECONDS)) {
				subscriberExecutor.shutdownNow();
			}
		} catch (InterruptedException e) {
			subscriberExecutor.shutdownNow();
		}
	}
}