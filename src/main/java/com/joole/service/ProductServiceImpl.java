package com.joole.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joole.dao.ProductDAO;
import com.joole.domain.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductServiceDAO{
	
	@Autowired
	private ProductDAO productDAO;

	

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		List<Product> products = productDAO.getAllProducts();
		return products;
	}

	@Override
	public List<Product> getProductsByComparison() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsByAdvancedSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductBySubcategory(String subCategory) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProductsBySubcategory(subCategory);
		return products;
	}

	

}
