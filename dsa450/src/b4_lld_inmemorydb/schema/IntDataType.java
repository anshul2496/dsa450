package b4_lld_inmemorydb.schema;

import b4_lld_inmemorydb.exceptions.OutOfRangeException;

public class IntDataType extends ColumnDataType<Integer> {
	private int minValue;
	private int maxValue;

	public IntDataType(int minValue, int maxValue) {
		super(Integer.class);
		this.minValue = minValue;
		this.maxValue = maxValue;
	}

	@Override
	public Integer validate(Object val) {
		Integer intValue = super.validate(val);
		if (intValue < minValue || intValue > maxValue) {
			throw new OutOfRangeException("int_out_of_range");
		}
		return intValue;
	}
}