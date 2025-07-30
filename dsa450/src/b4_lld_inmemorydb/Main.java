package b4_lld_inmemorydb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import b4_lld_inmemorydb.schema.IntDataType;
import b4_lld_inmemorydb.schema.SchemaMember;
import b4_lld_inmemorydb.schema.StrDataType;
import b4_lld_inmemorydb.schema.TableSchema;
import b4_lld_inmemorydb.table.Table;

/*
 * SQL - https://medium.com/@tg6897/design-in-memory-db-with-indexing-52d33adceb91
 * InMemory Key Value(like mini Redis) - https://chatgpt.com/share/688892c2-72e4-8003-aecc-863fbb2e72e8
 * Below code is like SQL.
 */
public class Main {
	public static void main(String[] args) {
		// Step 1: Create Schema
		TableSchema userSchema = new TableSchema();
		userSchema.addSchemaMember(new SchemaMember<>("user_id", new StrDataType(0, 10), true, false));
		userSchema.addSchemaMember(new SchemaMember<>("user_name", new StrDataType(0, 50), true, false));
		userSchema.addSchemaMember(new SchemaMember<>("user_age", new IntDataType(0, 100), false, false));

		// Step 2: Create Table
		Table userTable = new Table("users", userSchema, "user_id");

		// Step 3: Create Index on "user_name" using FUZZY index
		userTable.createIndex("user_name", "FUZZY"); 

		// Step 4: Insert seed data
		Map<String, Object> row1 = new HashMap<>();
		row1.put("user_id", "user1");
		row1.put("user_name", "new user");
		row1.put("user_age", 20);
		userTable.insertData(row1);

		Map<String, Object> row2 = new HashMap<>();
		row2.put("user_id", "user2");
		row2.put("user_name", "improved user");
		userTable.insertData(row2);

		Map<String, Object> row3 = new HashMap<>();
		row3.put("user_id", "user3");
		row3.put("user_name", "diff guy");
		row3.put("user_age", 30);
		userTable.insertData(row3);

		// Step 5: Query for user_name = "user"
		System.out.println("Filter: user_name=user");
		List<Map<String, Object>> result1 = userTable.filterData(Map.of("user_name", "user"));
		printResults(result1);

		// Step 6: Query for user_name = "user" and user_age = 20
		System.out.println("Filter: user_name=user, user_age=20");
		List<Map<String, Object>> result2 = userTable.filterData(Map.of("user_name", "new user", "user_age", "20"));
		printResults(result2);

		// Step 7: Delete one user and query again
		userTable.deleteData("user2");
		System.out.println("Filter: user_name=user after deletion of user2");
		List<Map<String, Object>> result3 = userTable.filterData(Map.of("user_name", "user"));
		printResults(result3);
	}

	private static void printResults(List<Map<String, Object>> data) {
		for (Map<String, Object> row : data) {
			System.out.println(row);
		}
		System.out.println();
	}
}
