package b4_lld_inmemorydb.database;
import java.util.*;

import b4_lld_inmemorydb.table.Table;

public class Database {
	/**
	 * Holds all tables in the database. Key = table name, Value = Table object
	 */
	private Map<String, Table> tables;

	public Database() {
		this.tables = new HashMap<>();
	}

	/**
	 * Adds a new table to the database.
	 *
	 * @param table Table instance to be added
	 */
	public void createTable(Table table) {
		String tableName = table.getTableName();
		if (tables.containsKey(tableName)) {
			throw new RuntimeException("Table_already_Exists");
		}
		tables.put(tableName, table);
	}

	/**
	 * Deletes a table from the database.
	 *
	 * @param tableName name of the table to be deleted
	 */
	public void deleteTable(String tableName) {
		if (!tables.containsKey(tableName)) {
			throw new RuntimeException("no_such_table_" + tableName);
		}
		tables.remove(tableName);
	}

	/**
	 * Optional getter for a table by name
	 */
	public Table getTable(String tableName) {
		if (!tables.containsKey(tableName)) {
			throw new RuntimeException("no_such_table_" + tableName);
		}
		return tables.get(tableName);
	}

	/**
	 * Optional method to check if a table exists
	 */
	public boolean hasTable(String tableName) {
		return tables.containsKey(tableName);
	}
}
