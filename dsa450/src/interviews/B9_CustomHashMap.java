package interviews;

import java.util.Objects;

/*
 * https://swapnilagarwal2001.medium.com/custom-hashmap-in-java-and-understanding-of-java-hashmap-3b97a115fdd4
 * https://chatgpt.com/share/6859a2dd-aca4-8003-a434-261f5910902d
 */
public class B9_CustomHashMap {

}

class CustomHashMap<K, V> {

	// Inner class to represent each entry (key-value pair)
	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}

	public static final int INITIAL_CAPACITY = 16;
	public static final float LOAD_FACTOR = 0.75f;

	Entry<K, V>[] buckets;
	int size;

	public CustomHashMap() {
		this.buckets = new Entry[INITIAL_CAPACITY];
		this.size = 0;
	}

	public int hash(K key) {
		return (key == null) ? 0 : Math.abs(key.hashCode());
		/*
		 * int h = key.hashCode(); return h ^ (h >>> 16); // better distribution
		 */
	}

	public int getIndex(K key) {
		if (key == null)
			return 0;
		else
			return hash(key) % buckets.length; // return hash(key) & (capacity - 1); // efficient mod
	}

	public void put(K key, V value) {
		int index = getIndex(key);
		Entry<K, V> head = buckets[index];
		// Check if key already exists
		while (head != null) {
			if (Objects.equals(key, head.key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Insert new entry at the beginning
		Entry<K, V> entry = new Entry<>(key, value);
		entry.next = buckets[index];
		buckets[index] = entry;
		size++;

		// Resize
		// if (size > LOAD_FACTOR * buckets.length) resize();
	}

	public V get(K key) {
		int index = getIndex(key);
		Entry<K, V> head = buckets[index];
		// Check if key already exists
		while (head != null) {
			if (Objects.equals(key, head.key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}

	public void remove(K key) {
		int index = getIndex(key);
		Entry<K, V> head = buckets[index];
		Entry<K, V> prev = null;
		// Check if key already exists
		while (head != null) {
			if (Objects.equals(key, head.key)) {
				if (prev == null) {
					buckets[index] = head.next;
				} else {
					prev.next = head.next;
				}
				head.next = null;
				size--;
				return;
			}
			prev = head;
			head = head.next;
		}
	}

	public void resize() {
		Entry<K, V>[] oldBuckets = this.buckets;
		this.buckets = new Entry[oldBuckets.length * 2];
		size = 0;
		for (Entry<K, V> entry : oldBuckets) {
			while (entry != null) {
				put(entry.key, entry.value);
				entry = entry.next;
			}
		}
	}
}
