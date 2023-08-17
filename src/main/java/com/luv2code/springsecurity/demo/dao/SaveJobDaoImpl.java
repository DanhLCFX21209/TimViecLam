package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.SaveJob;
import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class SaveJobDaoImpl implements SaveJobDao {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<SaveJob> getSavedJobsByUserId(int userId) {
	    // get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
	    System.out.println("---SaveJobDaoImpl-------");
	    
	    // now retrieve/read from database using userId
	    Query<SaveJob> theQuery = currentSession.createQuery("SELECT s FROM SaveJob s JOIN FETCH s.recruitment WHERE s.user.id = :userId", SaveJob.class);
	    theQuery.setParameter("userId", userId);
	    
	    List<SaveJob> theSaveJob = theQuery.getResultList();
		
		return theSaveJob;
	}

	@Override
	public void deleteSaveJob(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from SaveJob where recruitment_id=:saveJobId");
		theQuery.setParameter("saveJobId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public void save(SaveJob saveJob) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(saveJob);
		
	}
	
	
	

}
