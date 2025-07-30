package b4_lld_inmemorydb.schema;

import b4_lld_inmemorydb.exceptions.InvalidValueException;

public class SchemaMember<T> {
	private String columnName;
	private ColumnDataType<T> columnType;
	private boolean required;
	private boolean allowNone;

	/*
	 * This class provides the actual column to be used in schema It uses
	 * ColumnDataType class to enforce type
	 */
	public SchemaMember(String columnName, ColumnDataType<T> columnType) {
		this(columnName, columnType, true, false);
	}

	/*
	 * column_name : Name of the column 
	 * column_type: Instance of ColumnDataType class ie. can be IntDataType, StrDataType etc. 
	 * required: Is the column value required in data or not 
	 * allow_none: Is the column value allowed as null or not
	 */
	public SchemaMember(String columnName, ColumnDataType<T> columnType, boolean required, boolean allowNone) {
		this.columnName = columnName;
		this.columnType = columnType;
		this.required = required;
		this.allowNone = allowNone;
	}

	public T validateValue(Object val) {
		if (val == null && !allowNone) {
			throw new InvalidValueException("None_not_allowed_in_" + columnName);
		}
		return columnType.validate(val);
	}

	// Optional getters
	public String getColumnName() {
		return columnName;
	}

	public boolean isRequired() {
		return required;
	}

	public boolean isAllowNone() {
		return allowNone;
	}

	public ColumnDataType<T> getColumnType() {
		return columnType;
	}
}
