package com.example.repo;

import java.util.ArrayList;
import java.util.List;

import com.example.products.Product;

public class ProductRepo {

	private static ProductRepo productRepo;
	private List<Product> products;

	private ProductRepo() {
		products = new ArrayList<Product>();
		products.add(new Product(100, "Laptop", 4000));
		products.add(new Product(101, "Mouse", 100));
		products.add(new Product(102, "Earphone", 200));
		products.add(new Product(103, "Keyboard", 500));
	}

	public List<Product> getProducts() {
		return products;
	}

	public Product findProductById(int productId) {
		Product p = null;
		for (Product product : products) {
			if (product.getProductId() == productId) {
				p = new Product(product.getProductId(), product.getProductName(), product.getPrice());
				break;
			}
		}
		return p;
	}

	public void saveProduct(Product product) {
		Product p = findProductById(product.getProductId());
		if (p == null) {
			products.add(product);
		} else {
			for (int index = 0; index < products.size(); index++) {
				Product p1 = products.get(index);
				if (p1.getProductId() == p.getProductId()) {
					products.set(index, product);
					break;
				}
			}
		}
	}

	public void deleteProduct(int productId) {
		Product p = findProductById(productId);
		for (int index = 0; index < products.size(); index++) {
			Product p1 = products.get(index);
			if (p1.getProductId() == p.getProductId()) {
				products.remove(index);
				break;
			}
		}
		System.out.println(products);
	}

	public static ProductRepo getRepoInstance() {
		if (productRepo == null) {
			productRepo = new ProductRepo();
		}
		return productRepo;
	}
}
