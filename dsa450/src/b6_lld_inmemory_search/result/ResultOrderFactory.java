package b6_lld_inmemory_search.result;

import b6_lld_inmemory_search.constants.ResultOrderType;

public class ResultOrderFactory {
    public static ResultOrderStrategy createResultOrderStrategy(ResultOrderType resultOrderType) {
        return switch (resultOrderType) {
            case RECENTLY_PUBLISHED -> new RecentlyPublishedOrder();
            //case RECENTLY_UPDATED -> new RecentlyUpdatedOrder();
            //case RECENTLY_SEARCHED -> new RecentlySearchedOrder();
            //case AUTHOR_NAME -> new AuthorNameOrder();
            default -> null;
        };
    }
}
