package b7_lld_lru_cache;

/*
 * Taken from this - https://github.com/ashishps1/awesome-low-level-design/blob/main/solutions/java/src/lrucache/LRUCacheDemo.java
 * Not this - https://github.com/anomaly2104/cache-low-level-system-design/blob/master/src/main/java/com/uditagarwal/cache/Cache.java
 */
public class Main {
	public static void main(String[] args) {
		LRUCache<String, Integer> cache = new LRUCache<>(3);
		cache.put("a", 1);
		cache.put("b", 2);
		cache.put("c", 3);
		System.out.println(cache.get("a")); // 1
		cache.put("d", 4);
		System.out.println(cache.get("b")); // null
	}
}
