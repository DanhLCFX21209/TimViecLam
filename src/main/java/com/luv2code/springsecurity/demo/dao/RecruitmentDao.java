package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.User;

public interface RecruitmentDao {

	public List<Recruitment> getRecruitments();
		
	public Recruitment getRecruitment(int theId);
	
	public List<Recruitment> getStatusRecruitments();

	public List<Recruitment> findByRecruitmentName(String name);

    void save(Recruitment recruitment);
    
	public void deleteRecruitment(int theId);

}
