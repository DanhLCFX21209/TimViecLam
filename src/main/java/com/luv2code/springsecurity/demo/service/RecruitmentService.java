package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.Recruitment;

import java.util.List;


public interface RecruitmentService {

	public List<Recruitment> getRecruitments();
		
	public Recruitment getRecruitment(int theId);
	
	public List<Recruitment> findByRecruitmentName(String name);

	void save(Recruitment recruitment);
	
	public void deleteRecruitment(int theId);
	
	public List<Recruitment> getStatusRecruitments();


}
