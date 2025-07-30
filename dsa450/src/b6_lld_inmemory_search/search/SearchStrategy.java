package b6_lld_inmemory_search.search;

import java.util.List;

import b6_lld_inmemory_search.Category;
import b6_lld_inmemory_search.Document;

public interface SearchStrategy {
    public List<Document> search(Category category, String pattern);
}