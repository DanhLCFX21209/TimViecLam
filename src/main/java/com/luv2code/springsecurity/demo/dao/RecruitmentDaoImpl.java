package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.User;

@Repository
public class RecruitmentDaoImpl implements RecruitmentDao {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Recruitment> getRecruitments() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Recruitment> theQuery = currentSession.createQuery(
				"SELECT u FROM Recruitment u JOIN FETCH u.company  order by salary,quantity,created_at desc",
				Recruitment.class);

		// execute query and get result list
		List<Recruitment> recruitments = theQuery.getResultList();

		// return the results
		return recruitments;
	}

	@Override
	public Recruitment getRecruitment(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using name
		Query<Recruitment> theQuery = currentSession.createQuery(
				"SELECT d FROM Recruitment d JOIN FETCH d.company WHERE d.id = :companyId", Recruitment.class);
		theQuery.setParameter("companyId", theId);

		Recruitment theRecruitment = null;

		try {
			theRecruitment = theQuery.getSingleResult();
		} catch (Exception e) {
			theRecruitment = null;
		}

		return theRecruitment;
	}

	@Override
	public List<Recruitment> findByRecruitmentName(String name) {
	    // Get the current hibernate session
	    Session currentSession = sessionFactory.getCurrentSession();

	    // Retrieve/read from the database using the company name
	    Query<Recruitment> theQuery = currentSession.createQuery("SELECT r FROM Recruitment r JOIN FETCH r.company c WHERE r.title LIKE :title OR r.address LIKE :address OR c.nameCompany LIKE :companyName", Recruitment.class);
	    theQuery.setParameter("title", "%" + name + "%");
	    theQuery.setParameter("address", "%" + name + "%");
	    theQuery.setParameter("companyName", "%" + name + "%");

	    List<Recruitment> recruitments = theQuery.getResultList();

	    return recruitments;
	}

	@Override
	public void save(Recruitment recruitment) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create the user ... finally LOL
		currentSession.saveOrUpdate(recruitment);
	}

	@Override
	public void deleteRecruitment(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Recruitment where id=:recruitmentId");
		theQuery.setParameter("recruitmentId", theId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Recruitment> getStatusRecruitments() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query ... sort by last name
		Query<Recruitment> theQuery = currentSession.createQuery("FROM Recruitment WHERE status = 1",
				Recruitment.class);

		// execute query and get result list
		List<Recruitment> recruitments = theQuery.getResultList();

		// return the results
		return recruitments;
	}

}
