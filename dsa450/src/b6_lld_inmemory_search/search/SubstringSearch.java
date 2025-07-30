package b6_lld_inmemory_search.search;

import java.util.List;
import java.util.stream.Collectors;

import b6_lld_inmemory_search.Category;
import b6_lld_inmemory_search.Document;

public class SubstringSearch implements SearchStrategy {
    @Override
    public List<Document> search(Category category, String pattern) {
        return category.getDocuments().stream()
                .filter(doc -> doc.getContent().toLowerCase().contains(pattern.toLowerCase()))
                .collect(Collectors.toList());
    }
}
