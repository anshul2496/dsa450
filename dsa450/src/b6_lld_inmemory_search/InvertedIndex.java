package b6_lld_inmemory_search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InvertedIndex {
	private Map<String, Set<Document>> index;

	public InvertedIndex() {
		index = new HashMap<>();
	}

	public void addDocument(Document document) {
		String[] words = document.getContent().toLowerCase().split("\\W+");
		for (String word : words) {
			if (!index.containsKey(word)) {
				Set<Document> set = new HashSet<>();
				set.add(document);
				index.put(word, set);
			} else {
				index.get(word).add(document);
			}
		}
	}

	public Set<Document> getDocumentsForWord(String word) {
		return index.get(word);
	}
}