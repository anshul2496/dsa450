package b4_lld_inmemorydb.indexes;
import java.util.*;
import java.util.regex.Pattern;

public class FuzzyIndex extends Index {
	/**
	 * Fuzzy index: tokenizes values and stores primary key in each token bucket.
	 */
	private String separator;

	public FuzzyIndex(String indexName, String primaryKey, String separator) {
		super(indexName, primaryKey);
		this.separator = separator;
	}

	public FuzzyIndex(String indexName, String primaryKey) {
		this(indexName, primaryKey, " "); // Default separator is space
	}

	/**
	 * Helper method to tokenize the value based on separator.
	 */
	private List<String> getFuzzyValues(Map<String, Object> rowData) {
		Object value = rowData.get(indexName);
		if (value == null)
			return Collections.emptyList();
		return Arrays.asList(((String) value).split(Pattern.quote(separator)));
	}

	@Override
	protected void indexData(Map<String, Object> rowData) {
		Object primaryValue = rowData.get(primaryKey);
		for (String token : getFuzzyValues(rowData)) {
			indexStorage.computeIfAbsent(token, k -> new HashSet<>()).add(primaryValue);
		}
	}

	@Override
	public void removeIndexedVal(Map<String, Object> rowData) {
		Object primaryValue = rowData.get(primaryKey);
		for (String token : getFuzzyValues(rowData)) {
			if (!indexStorage.containsKey(token))
				continue;
			Set<Object> values = indexStorage.get(token);
			values.remove(primaryValue);
			if (values.isEmpty()) {
				indexStorage.remove(token); // Optional cleanup
			}
		}
	}
}
