package b6_lld_inmemory_search.result;

import java.util.List;

import b6_lld_inmemory_search.Document;
import b6_lld_inmemory_search.constants.SortOrderType;

public interface ResultOrderStrategy {
    public List<Document> sort(List<Document> documents, SortOrderType sortOrderType);
}