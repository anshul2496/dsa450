package c6_online_shopping_service.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import c6_online_shopping_service.enums.ProductCategory;
import c6_online_shopping_service.models.Product;

public class SearchService {
	private final Collection<Product> productCatalog;

	public SearchService(Collection<Product> productCatalog) {
		this.productCatalog = productCatalog;
	}

	public List<Product> searchByName(String name) {
		List<Product> result = new ArrayList<>();
		productCatalog.stream().filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
				.forEach(result::add);
		return result;
	}

	public List<Product> searchByCategory(ProductCategory category) {
		List<Product> result = new ArrayList<>();
		productCatalog.stream().filter(p -> p.getCategory() == category).forEach(result::add);
		return result;
	}
}
