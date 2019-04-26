package com.joole.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.domain.Product;
import com.joole.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts() {
		System.out.println("in products");
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// filter products
	@RequestMapping(value = "/filter", method = RequestMethod.POST)
	public ResponseEntity<List<Product>> filterProducts(@RequestBody Map<String, Object[]> filter) {

		List<Product> products = productService.filterProducts(filter);

		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{subCategoryname}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Object>>> listProductsBySubcategory(
			@PathVariable("subCategoryname") String subCategoryname) {
		Map<String, List<Object>> map = productService.getProductsBySubcategory(subCategoryname);

		if (map.isEmpty()) {
			return new ResponseEntity<Map<String, List<Object>>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Map<String, List<Object>>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/pid={productId}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listProductDetails(@PathVariable("productId") int pid) {
		List<Product> products = productService.getProduct(pid);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/comparison/pl={productList}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listProductInComparison(
			@PathVariable("productList") List<Integer> productList) {
		List<Product> products = productService.getProductsByComparison(productList);
		if (products.isEmpty()) {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
