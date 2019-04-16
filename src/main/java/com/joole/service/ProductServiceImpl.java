package com.joole.service;

import java.io.StringReader;
import java.util.List;

import javax.transaction.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.joole.dao.ProductDAO;
import com.joole.dao.SubCategoryDAO;
import com.joole.domain.Product;
import com.joole.domain.SubCategory;

@Service
@Transactional
public class ProductServiceImpl implements ProductServiceDAO {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Override
	@Transactional
	public List<Product> getProduct(int pid) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProduct(pid);
		return products;
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		List<Product> products = productDAO.getAllProducts();
		return products;
	}

	@Override
	public List<Product> getProductsByComparison(List<Integer> productList) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProductsByComparison(productList);
		return products;
	}

	@Override
	public List<Product> getProductsByAdvancedSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<Product> getProductsBySubcategory(String subCategory) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProductsBySubcategory(subCategory);

		return products;
	}

	@Override
	@Transactional
	public List<Product> filterProducts() {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getAllProducts();

		SubCategory subCategory = subCategoryDAO.getSubCategoty(1);
		Document parameters = convertStringToXMLDocument(subCategory.getParameters());

		
		return products;
	}

	private Document convertStringToXMLDocument(String xmlString) {
		// Parser that produces DOM object trees from XML content
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// API to obtain DOM Document instance
		DocumentBuilder builder = null;
		try {
			// Create DocumentBuilder with default configuration
			builder = factory.newDocumentBuilder();

			// Parse the content to Document object
			Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
