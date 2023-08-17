package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.ApplypostDao;
import com.luv2code.springsecurity.demo.dao.CategoryDao;
import com.luv2code.springsecurity.demo.dao.CompanyDao;
import com.luv2code.springsecurity.demo.dao.RecruitmentDao;
import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.Category;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;

@Service
public class CompanyServiceImpl implements CompanyService,RecruitmentService,CategoryService,ApplypostService {

	// need to inject customer dao
	@Autowired
	private CompanyDao companyDao;
	
	@Autowired
	private RecruitmentDao recruitmentDao;

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ApplypostDao applypostDao;
	
	
	@Override
	@Transactional
	public List<Company> getCompanies() {
		return companyDao.getCompanies();
	}


	@Override
	@Transactional
	public List<Recruitment> getRecruitments() {
		return recruitmentDao.getRecruitments();
	}	
	
	
	@Override
	@Transactional
	public List<Category> getCategories() {
		return categoryDao.getCategories();
	}


	@Override
	@Transactional
	public Company getCompanyByUserId(int userId) {
        return companyDao.getCompanyByUserId(userId);
	}


	@Override
	@Transactional
	public List<Applypost> getApplyposts() {
		return applypostDao.getApplyposts();
	}


	@Override
	@Transactional
	public Recruitment getRecruitment(int theId) {
		return recruitmentDao.getRecruitment(theId);
	}


	@Override
	@Transactional
	public List<Recruitment> findByRecruitmentName(String name) {
		return recruitmentDao.findByRecruitmentName(name);
	}


	@Override
	@Transactional
	public List<Company> findByCompanyName(String name) {
		return companyDao.findByCompanyName(name);
	}


	@Override
	@Transactional
	public Company getCompany(int theId) {
		return companyDao.getCompany(theId);
	}


	@Override
	@Transactional
	public void save(Company company) {
		companyDao.save(company);
	}


	@Override
	@Transactional
	public void save(Recruitment recruitment) {
		recruitmentDao.save(recruitment);
	}


	@Override
	@Transactional
	public void deleteRecruitment(int theId) {
		recruitmentDao.deleteRecruitment(theId);
		
	}


	@Override
	@Transactional
	public void deleteApplypost(int theId) {
		applypostDao.deleteApplypost(theId);		
	}


	@Override
	@Transactional
	public List<Recruitment> getStatusRecruitments() {
		return recruitmentDao.getStatusRecruitments();
	}


	@Override
	@Transactional
	public List<Company> getStatusCompanies() {
		return companyDao.getStatusCompanies();
	}


	@Override
	@Transactional
	public Applypost getApplypostByRecruitmentId(int recruitmentId) {
		return applypostDao.getApplypostByRecruitmentId(recruitmentId);
	}


	@Override
	@Transactional
	public void save(Applypost applypost) {
		applypostDao.save(applypost);
	}


	@Override
	@Transactional
	public Applypost getApplypostByUserId(int userId) {
		return applypostDao.getApplypostByUserId(userId);
	}

	

}
