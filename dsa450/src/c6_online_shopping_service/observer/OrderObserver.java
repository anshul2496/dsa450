package c6_online_shopping_service.observer;

import c6_online_shopping_service.models.Order;

public interface OrderObserver {
    void update(Order order);
}
