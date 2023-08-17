package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Category;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	
	@Override
	public List<Category> getCategories() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Category> theQuery = 
				currentSession.createQuery("FROM Category",
											Category.class);
		
		// execute query and get result list
		List<Category> categories = theQuery.getResultList();
				
		// return the results		
		return categories;	
	}

	
}
