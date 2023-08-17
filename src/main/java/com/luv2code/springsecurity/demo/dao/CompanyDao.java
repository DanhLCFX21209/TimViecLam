package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;

public interface CompanyDao {

	public List<Company> getCompanies();
	
	public Company getCompanyByUserId(int userId);

	public List<Company> findByCompanyName(String name);
	
	public Company getCompany(int theId);
	
    void save(Company company);
    
	public List<Company> getStatusCompanies();




}
