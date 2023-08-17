package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.User;

import java.util.List;


public interface CompanyService {

	public List<Company> getCompanies();
	
	public Company getCompanyByUserId(int userId);
	
	public List<Company> findByCompanyName(String name);
	
	public Company getCompany(int theId);

    void save(Company company);

	public List<Company> getStatusCompanies();


}
