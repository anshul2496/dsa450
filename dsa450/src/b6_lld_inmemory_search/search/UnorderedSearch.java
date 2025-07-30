package b6_lld_inmemory_search.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import b6_lld_inmemory_search.Category;
import b6_lld_inmemory_search.Document;

public class UnorderedSearch implements SearchStrategy {
    @Override
    public List<Document> search(Category category, String pattern) {
        String[] words = pattern.toLowerCase().split(" ");
        Set<Document> documents = category.getInvertedIndex().getDocumentsForWord(words[0]);
        for (int i = 1; i < words.length; i++) {
            documents.retainAll(category.getInvertedIndex().getDocumentsForWord(words[i]));
        }
        return new ArrayList<>(documents);
    }
}