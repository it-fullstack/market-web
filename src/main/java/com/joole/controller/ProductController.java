package com.joole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.domain.Product;
import com.joole.service.ProductServiceDAO;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceDAO productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		System.out.println("in products");
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{sub_id}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> getProductsBySubcategory(@PathVariable("sub_id") int sub_id) {
		System.out.println("in subcategory");
		List<Product> products = productService.getProductBySubcategory(sub_id);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// filter products
	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> filterProducts() {
		List<Product> products = productService.filterProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);// You many decide to return
																			// HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);

	}

}
