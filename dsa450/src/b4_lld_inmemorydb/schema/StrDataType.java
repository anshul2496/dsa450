package b4_lld_inmemorydb.schema;

import b4_lld_inmemorydb.exceptions.OutOfRangeException;

public class StrDataType extends ColumnDataType<String> {
	private int minLength;
	private int maxLength;

	public StrDataType(int minLength, int maxLength) {
		super(String.class);
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	@Override
	public String validate(Object val) {
		String strVal = super.validate(val);
		if (strVal.length() < minLength || strVal.length() > maxLength) {
			throw new OutOfRangeException("string_len_out_of_range");
		}
		return strVal;
	}
}
