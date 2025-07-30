package b4_lld_inmemorydb.schema;
import java.util.HashMap;
import java.util.Map;

import b4_lld_inmemorydb.exceptions.MissingValueException;
import b4_lld_inmemorydb.exceptions.UndefinedSchemaMember;

/*
 *  Defines Schema of the table to be used
    It does validation/transformation over the row data
 */
public class TableSchema {
	private final Map<String, SchemaMember<?>> schemaMembers;
	private final boolean allowUndefined;

	public TableSchema() {
		this(false);
	}

	public TableSchema(boolean allowUndefined) {
		/*
		 *  schema_members: Instance of SchemaMember class
        	allow_undefined: is any column for which schema member is not defined allowed?
		 */
		this.schemaMembers = new HashMap<>();
		this.allowUndefined = allowUndefined;
	}

	public void addSchemaMember(SchemaMember<?> schemaMember) {
		schemaMembers.put(schemaMember.getColumnName(), schemaMember);
	}

	public Map<String, Object> validateRowData(Map<String, Object> rowData) {
		/*
		 *  validates row data
        	Multi level validation
        	TableSchema : validates any undefined values
        	SchemaMember : validates null check
        	Column_data_type:  validates value type and ranges.
		 */
		Map<String, Object> validatedData = new HashMap<>();

		for (Map.Entry<String, Object> entry : rowData.entrySet()) {
			String colName = entry.getKey();
			Object colVal = entry.getValue();

			if (!schemaMembers.containsKey(colName)) {
				if (!allowUndefined) {
					throw new UndefinedSchemaMember("undefined_schema_member_" + colName);
				}
				validatedData.put(colName, colVal);
				continue;
			}

			SchemaMember<?> member = schemaMembers.get(colName);
			validatedData.put(colName, member.validateValue(colVal));
		}

		for (Map.Entry<String, SchemaMember<?>> entry : schemaMembers.entrySet()) {
			String colName = entry.getKey();
			SchemaMember<?> member = entry.getValue();

			if (member.isRequired() && !rowData.containsKey(colName)) {
				throw new MissingValueException("col_name_" + colName + "_missing");
			}
		}

		return validatedData;
	}
}
