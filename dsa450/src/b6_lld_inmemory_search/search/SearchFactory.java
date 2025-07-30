package b6_lld_inmemory_search.search;

import b6_lld_inmemory_search.constants.SearchType;

public class SearchFactory {
    public static SearchStrategy createSearchStrategy(SearchType type) {
        return switch (type) {
            case UNORDERED -> new UnorderedSearch();
            case SUBSTRING -> new SubstringSearch();
            default -> null;
        };
    }
}
