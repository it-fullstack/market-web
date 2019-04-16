package com.joole.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.joole.domain.SubCategory;

@Repository
public class SubCategoryDAOImpl implements SubCategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public SubCategory getSubCategoty(int id) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();

		Transaction tx = session.beginTransaction();
		SubCategory subCategoty = (SubCategory) session.get(SubCategory.class, id);
		tx.commit();
		return subCategoty;
	}

}
