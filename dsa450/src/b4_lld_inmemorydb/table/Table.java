package b4_lld_inmemorydb.table;
import java.util.*;

import b4_lld_inmemorydb.indexes.Index;
import b4_lld_inmemorydb.schema.TableSchema;

public class Table {

    private String tableName;
    private TableSchema tableSchema;
    private String primaryKey;

    // Maps primary key to row data (key = primary key value, value = row)
    private Map<Object, Map<String, Object>> tableData;

    // Maps column name to index instance
    private Map<String, Index> indexes;

    public Table(String tableName, TableSchema tableSchema, String primaryKey) {
        this.tableName = tableName;
        this.tableSchema = tableSchema;
        this.primaryKey = primaryKey;
        this.indexes = new HashMap<>();
        this.tableData = new HashMap<>();
    }

    /**
     * Creates an index on a given column with the specified index type.
     */
    public void createIndex(String columnName, String indexType) {
        if (indexes.containsKey(columnName)) {
            throw new RuntimeException("Index_already_exists_" + columnName);
        }
        IndexType type = IndexType.valueOf(indexType); // assumes valid enum string
        indexes.put(columnName, type.getIndexInstance(columnName, primaryKey));
    }

    /**
     * Insert a row into the table.
     * 1. Validate the row against schema.
     * 2. Insert into storage.
     * 3. Index the row.
     */
    public void insertData(Map<String, Object> rowData) {
        tableSchema.validateRowData(rowData);
        Object pk = rowData.get(primaryKey);
        tableData.put(pk, rowData);
        indexRowData(rowData);
    }

    /**
     * Index the row using all defined indexes.
     */
    private void indexRowData(Map<String, Object> rowData) {
        for (String indexCol : indexes.keySet()) {
            if (rowData.containsKey(indexCol)) {
                indexes.get(indexCol).indexRowData(rowData);
            }
        }
    }

    /**
     * Delete a row and remove it from all indexes.
     */
    public void deleteData(String key) {
        if (!tableData.containsKey(key)) {
            throw new RuntimeException("Record_not_present_with_key_" + primaryKey);
        }
        Map<String, Object> row = tableData.get(key);
        tableData.remove(key);

        for (String indexCol : indexes.keySet()) {
            if (row.containsKey(indexCol)) {
                indexes.get(indexCol).removeIndexedVal(row);
            }
        }
    }

    /**
     * Scan through data and filter based on non-indexed filters (AND logic).
     */
    private List<Map<String, Object>> scanTable(Map<String, Object> filters, Collection<Map<String, Object>> data) {
        if (filters.isEmpty()) return new ArrayList<>(data);

        List<Map<String, Object>> result = new ArrayList<>();
        for (Map<String, Object> row : data) {
            boolean matches = true;
            for (String filterKey : filters.keySet()) {
                if (row.get(filterKey)!=null && !(filters.get(filterKey).toString().equals(row.get(filterKey).toString()))) {
                    matches = false;
                    break;
                }
            }
            if (matches) {
                result.add(row);
            }
        }
        return result;
    }

    /**
     * Filter using indexes only. Applies AND logic across all indexed columns.
     */
    private Set<Object> filterOnIndexes(Map<String, Object> filters, List<String> indexedCols) {
        Set<Object> result = null;
        for (String col : indexedCols) {
            Set<Object> indexMatches = indexes.get(col).getData(filters.get(col));
            if (result == null) {
                result = new HashSet<>(indexMatches);
            } else {
                result.retainAll(indexMatches); // AND operation
            }
        }
        return result;
    }

    /**
     * Main filtering function:
     * 1. Use indexes if available.
     * 2. Then use scan on reduced dataset.
     */
    public List<Map<String, Object>> filterData(Map<String, Object> filters) {
        if (filters.containsKey(primaryKey)) {
        	Object pkValue = filters.get(primaryKey);
            if (tableData.containsKey(pkValue)) {
                return List.of(tableData.get(pkValue));
            }
            return List.of();
        }

        List<String> indexed = new ArrayList<>();
        List<String> nonIndexed = new ArrayList<>();

        for (String key : filters.keySet()) {
            if (indexes.containsKey(key)) {
                indexed.add(key);
            } else {
                nonIndexed.add(key);
            }
        }

        Set<Object> filteredKeys = filterOnIndexes(filters, indexed);
        List<Map<String, Object>> filteredRows = new ArrayList<>();

        if (filteredKeys != null) {
            for (Object key : filteredKeys) {
                if (tableData.containsKey(key)) {
                    filteredRows.add(tableData.get(key));
                }
            }
        }

        // Final scan on non-indexed filters
        Map<String, Object> nonIndexedFilters = new HashMap<>();
        for (String key : nonIndexed) {
            nonIndexedFilters.put(key, filters.get(key));
        }

        Collection<Map<String, Object>> dataset = indexed.isEmpty() ? tableData.values() : filteredRows;
        return scanTable(nonIndexedFilters, dataset);
    }

	public String getTableName() {
		return this.tableName;
	}
}
