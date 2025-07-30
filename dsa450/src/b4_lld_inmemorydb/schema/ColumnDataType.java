package b4_lld_inmemorydb.schema;

public abstract class ColumnDataType<T> {
	protected Class<T> dataType;

	public ColumnDataType(Class<T> dataType) {
		this.dataType = dataType;
	}

	public T validate(Object val) {
		if (!dataType.isInstance(val)) {
			throw new RuntimeException("Invalid_data_point_type");
		}
		return dataType.cast(val);
	}
}
