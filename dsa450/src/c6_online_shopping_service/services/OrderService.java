package c6_online_shopping_service.services;

import java.util.ArrayList;
import java.util.List;

import c6_online_shopping_service.models.Customer;
import c6_online_shopping_service.models.Order;
import c6_online_shopping_service.models.OrderLineItem;
import c6_online_shopping_service.models.ShoppingCart;

public class OrderService {
	private final InventoryService inventoryService;

	public OrderService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public Order createOrder(Customer customer, ShoppingCart cart) {
		List<OrderLineItem> result = new ArrayList<>();
		cart.getItems().values().stream().map(cartItem -> new OrderLineItem(cartItem.getProduct().getId(),
				cartItem.getProduct().getName(), cartItem.getQuantity(), cartItem.getProduct().getPrice()))
				.forEach(result::add);

		inventoryService.updateStockForOrder(result);

		return new Order(customer, result, customer.getShippingAddress(), cart.calculateTotal());
	}
}
