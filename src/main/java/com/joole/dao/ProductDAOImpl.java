package com.joole.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joole.domain.Product;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();

		List<Product> products = session.createQuery("from Product").list();
		tx.commit();
		return products;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getProductsBySubcategory(String subCategory) {
		// TODO Auto-generated method stub


		
		Session session = this.sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();
		String hql = "from Product where subCategoryId = 1";
//		String hql = "from Product where subCategory.subCategoryName = " + subCategory;
		List<Product> products = session.createQuery(hql).list();
		tx.commit();
		return products;

	}

	@Override
	public Product getProduct() {
		// TODO Auto-generated method stub
		return null;
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

}
