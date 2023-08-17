package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Company> getCompanies() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Company> theQuery = 
				currentSession.createQuery("FROM Company c JOIN FETCH c.recruitments order by quantity desc",
											Company.class);
		
		// execute query and get result list
		List<Company> companys = theQuery.getResultList();
				
		// return the results		
		return companys;	
	}

	@Override
	public Company getCompanyByUserId(int userId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Company> theQuery = currentSession.createQuery("SELECT c FROM Company c WHERE c.user.id = :userId", Company.class);
		theQuery.setParameter("userId", userId);
		
		Company theRole = null;
		
		try {
			theRole = theQuery.getSingleResult();
		} catch (Exception e) {
			theRole = null;
		}
		
		return theRole;
	}

	@Override
	public List<Company> findByCompanyName(String name) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using username
		Query<Company> theQuery = currentSession.createQuery("FROM Company u WHERE u.name_company LIKE :name", Company.class);
		theQuery.setParameter("name", "%" + name + "%");
		
		List<Company> companies = theQuery.getResultList();


		return companies;
	}

	@Override
	public Company getCompany(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Company theCompany = currentSession.get(Company.class, theId);
		
		return theCompany;
	}

	@Override
	public void save(Company company) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(company);
		
	}

	@Override
	public List<Company> getStatusCompanies() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Company> theQuery = 
				currentSession.createQuery("FROM Company WHERE status = 1",
						Company.class);
		
		// execute query and get result list
		List<Company> recruitments = theQuery.getResultList();
				
		// return the results		
		return recruitments;	
	}
	

	
	
}
