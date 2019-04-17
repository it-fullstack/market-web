package com.joole.service;

import java.util.List;

import com.joole.domain.Product;

public interface ProductServiceDAO {
	
	// product list view
		public List<Product> getProductsBySubcategory(String subCategory);
		
		public List<Product> getAllProducts();
		
		// basic product page view
		public List<Product> getProduct(int pid);
		
		// product comparison
		public List<Product> getProductsByComparison(List<Integer> productList);
		
		//advanced product search
		public List<Product> getProductsByAdvancedSearch();
		
		public List<Product> filterProducts();

}
