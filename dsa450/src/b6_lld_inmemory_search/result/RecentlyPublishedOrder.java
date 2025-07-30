package b6_lld_inmemory_search.result;

import java.util.List;

import b6_lld_inmemory_search.Document;
import b6_lld_inmemory_search.constants.SortOrderType;

public class RecentlyPublishedOrder implements ResultOrderStrategy {
	@Override
	public List<Document> sort(List<Document> documents, SortOrderType sortOrderType) {
		if (sortOrderType == SortOrderType.ASC) {
			documents.sort((doc1, doc2) -> doc1.getPublishDate().compareTo(doc2.getPublishDate()));
		} else {
			documents.sort((doc1, doc2) -> doc2.getPublishDate().compareTo(doc1.getPublishDate()));
		}
		return documents;
	}
}
