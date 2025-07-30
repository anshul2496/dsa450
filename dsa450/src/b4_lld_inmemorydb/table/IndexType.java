package b4_lld_inmemorydb.table;

import b4_lld_inmemorydb.indexes.FuzzyIndex;
import b4_lld_inmemorydb.indexes.Index;
import b4_lld_inmemorydb.indexes.ReverseIndex;

public enum IndexType {
    REVERSE {
        @Override
        public Index getIndexInstance(String columnName, String primaryKey) {
            return new ReverseIndex(columnName, primaryKey);
        }
    },
    FUZZY {
        @Override
        public Index getIndexInstance(String columnName, String primaryKey) {
            return new FuzzyIndex(columnName, primaryKey);
        }
    };

    public abstract Index getIndexInstance(String columnName, String primaryKey);
}