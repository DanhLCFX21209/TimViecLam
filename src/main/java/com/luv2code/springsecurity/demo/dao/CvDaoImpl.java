package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class CvDaoImpl implements CvDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Cv cv) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create the user ... finally LOL
		currentSession.saveOrUpdate(cv);
	}

	@Override
	public Cv getCv(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Cv theCv = currentSession.get(Cv.class, theId);
		
		return theCv;
	}

	@Override
	public Cv getCvByUserId(int userId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Cv> theQuery = currentSession.createQuery("SELECT c FROM Cv c WHERE c.user.id = :userId", Cv.class);
		theQuery.setParameter("userId", userId);
		
		Cv theCv = null;
		
		try {
			theCv = theQuery.getSingleResult();
		} catch (Exception e) {
			theCv = null;
		}
		
		return theCv;
	}

	
	

	
	
}
