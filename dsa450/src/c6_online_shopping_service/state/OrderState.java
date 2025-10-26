package c6_online_shopping_service.state;

import c6_online_shopping_service.models.Order;

public interface OrderState {
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
}
