package b6_lld_inmemory_search;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import b6_lld_inmemory_search.constants.ResultOrderType;
import b6_lld_inmemory_search.constants.SearchType;
import b6_lld_inmemory_search.constants.SortOrderType;
import b6_lld_inmemory_search.result.ResultOrderFactory;
import b6_lld_inmemory_search.result.ResultOrderStrategy;
import b6_lld_inmemory_search.search.SearchFactory;
import b6_lld_inmemory_search.search.SearchStrategy;

public class TechBlogEngine {
	private static TechBlogEngine instance;
	private final Map<String, Category> categoryMap;

	private TechBlogEngine() {
		categoryMap = new HashMap<>();
	}

	public static synchronized TechBlogEngine getInstance() {
		if (instance == null) {
			instance = new TechBlogEngine();
		}
		return instance;
	}

	public void createCategory(String categoryName) {
		Category category = new Category(categoryName);
		categoryMap.put(categoryName, category);
	}

	public void addDocumentToCategory(String categoryName, String documentName, String content, String author) {
		Category category = categoryMap.get(categoryName);
		Document document = new Document(documentName, content, author);
		category.addDocument(document);
	}

	public List<Document> search(String categoryName, String pattern, SearchType searchType,
			ResultOrderType resultOrderType, SortOrderType sortOrderType) {
		Category category = categoryMap.get(categoryName);
		SearchStrategy searchStrategy = SearchFactory.createSearchStrategy(searchType);
		List<Document> searchResult = searchStrategy.search(category, pattern);
		ResultOrderStrategy resultOrderStrategy = ResultOrderFactory.createResultOrderStrategy(resultOrderType);
		return resultOrderStrategy.sort(searchResult, sortOrderType);
	}
}
