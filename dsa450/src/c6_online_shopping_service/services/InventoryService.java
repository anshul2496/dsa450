package c6_online_shopping_service.services;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import c6_online_shopping_service.exceptions.OutOfStockException;
import c6_online_shopping_service.models.OrderLineItem;
import c6_online_shopping_service.models.Product;

public class InventoryService {
	private final Map<String, Integer> stock; // productId -> quantity

	public InventoryService() {
		this.stock = new ConcurrentHashMap<>();
	}

	public void addStock(Product product, int quantity) {
		stock.put(product.getId(), stock.getOrDefault(product.getId(), 0) + quantity);
	}

	public synchronized void updateStockForOrder(List<OrderLineItem> items) {
		// First, check if all items are in stock
		for (OrderLineItem item : items) {
			if (stock.getOrDefault(item.getProductId(), 0) < item.getQuantity()) {
				throw new OutOfStockException("Not enough stock for product ID: " + item.getProductId());
			}
		}
		// If all checks pass, deduct the stock
		for (OrderLineItem item : items) {
			stock.compute(item.getProductId(), (id, currentStock) -> currentStock - item.getQuantity());
		}
	}
}
