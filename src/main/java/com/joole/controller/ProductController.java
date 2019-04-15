package com.joole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.dao.ProductDAO;
import com.joole.domain.Product;

@RestController
public class ProductController {
	
	@Autowired
	private ProductDAO productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllProducts() {
		System.out.println("in products");
        List<Product> products = productService.getAllProducts();
        if(products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        for(Product product : products) {
        	System.out.println(product);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
	
//	@RequestMapping(value = "/products/")
//	public ModelAndView listAllProducts(ModelAndView mv) {
//		System.out.println("haha");
//		List<Product> products = productService.getAllProducts();
//		for(Product product : products) {
//			System.out.println(product);
//		}
//		return mv;
//	}


}
