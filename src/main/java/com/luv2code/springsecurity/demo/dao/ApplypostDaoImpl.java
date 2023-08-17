package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.SaveJob;
import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class ApplypostDaoImpl implements ApplypostDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;



	@Override
	public List<Applypost> getApplyposts() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query  ... sort by last name
		Query<Applypost> theQuery = 
				currentSession.createQuery("FROM Applypost",
											Applypost.class);
		
		// execute query and get result list
		List<Applypost> applyposts = theQuery.getResultList();
				
		// return the results		
		return applyposts;
	}



	@Override
	public void deleteApplypost(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Applypost where recruitment_id=:applypostId");
		theQuery.setParameter("applypostId", theId);
		
		theQuery.executeUpdate();
		
	}



	@Override
	public Applypost getApplypostByRecruitmentId(int recruitmentId) {
	    // get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	    
	    // now retrieve/read from database using userId
	    Query<Applypost> theQuery = currentSession.createQuery("SELECT s FROM Applypost s JOIN FETCH s.recruitment WHERE s.recruitment.id = :recruitmentId", Applypost.class);
	    theQuery.setParameter("recruitmentId", recruitmentId);
	    
		Applypost theApplypost = null;
		try {
			theApplypost = theQuery.getSingleResult();
		} catch (Exception e) {
			theApplypost = null;
		}
		
		return theApplypost;
	}



	@Override
	public void save(Applypost applypost) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(applypost);
		
	}



	@Override
	public Applypost getApplypostByUserId(int userId) {
	    // get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	    
	    // now retrieve/read from database using userId
	    Query<Applypost> theQuery = currentSession.createQuery("SELECT s FROM Applypost s JOIN FETCH s.user WHERE s.user.id = :userId", Applypost.class);
	    theQuery.setParameter("userId", userId);
	    
		Applypost theApplypost = null;
		try {
			theApplypost = theQuery.getSingleResult();
		} catch (Exception e) {
			theApplypost = null;
		}
		
		return theApplypost;
	}


	
	

	
	
	
}
