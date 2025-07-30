package b4_lld_inmemorydb.indexes;
import java.util.*;

public class ReverseIndex extends Index {
	/**
	 * Basic reverse index implementation: maps value -> set of primary keys.
	 */

	public ReverseIndex(String indexName, String primaryKey) {
		super(indexName, primaryKey);
	}

	@Override
	protected void indexData(Map<String, Object> rowData) {
		Object key = rowData.get(indexName);
		Object value = rowData.get(primaryKey);

		indexStorage.computeIfAbsent(key, k -> new HashSet<>()).add(value);
	}

	@Override
	public void removeIndexedVal(Map<String, Object> rowData) {
		Object key = rowData.get(indexName);
		Object value = rowData.get(primaryKey);

		if (indexStorage.containsKey(key)) {
			indexStorage.get(key).remove(value);
			if (indexStorage.get(key).isEmpty()) {
				indexStorage.remove(key); // Optional cleanup
			}
		}
	}
}
