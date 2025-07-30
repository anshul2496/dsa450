package b4_lld_inmemorydb.indexes;
import java.util.*;

public abstract class Index {
	/**
	 * Base class for Index Provides interface for indexing, querying, and removing
	 * indexes. Currently uses TreeMap (SortedDict equivalent) as storage.
	 */
	protected String indexName;
	protected String primaryKey;
	protected Map<Object, Set<Object>> indexStorage;

	public Index(String indexName, String primaryKey) {
		this.indexName = indexName;
		this.primaryKey = primaryKey;
		this.indexStorage = new TreeMap<>(); // TreeMap = SortedDict
	}

	/**
	 * Indexes the row data after removing any older index.
	 */
	public void indexRowData(Map<String, Object> rowData) {
		removeIndexedVal(rowData);
		indexData(rowData);
	}

	/**
	 * Implement in subclasses to define how to index data.
	 */
	protected abstract void indexData(Map<String, Object> rowData);

	/**
	 * Returns values satisfying the filter condition.
	 */
	public Set<Object> getData(Object filterVal) {
		return indexStorage.getOrDefault(filterVal, new HashSet<>());
	}

	/**
	 * Implement in subclasses to define how to remove indexed values.
	 */
	public abstract void removeIndexedVal(Map<String, Object> rowData);
}
