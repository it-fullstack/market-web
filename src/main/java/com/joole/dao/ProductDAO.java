package com.joole.dao;

import java.util.List;

import com.joole.domain.Product;

public interface ProductDAO {
	
	// product list view
	public List<Product> getProductBySubcategory();
	
	// basic product page view
	public Product getProduct();
	
	// product comparison
	public List<Product> getProductsByComparison();
	
	//advanced product search
	public List<Product> getProductsByAdvancedSearch();
	//test test shuangjin	
	
	
	

}
