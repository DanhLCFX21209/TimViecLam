package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.Applypost;

import java.util.List;


public interface ApplypostService {

	public List<Applypost> getApplyposts();
	
	public void deleteApplypost(int theId);
	
    public Applypost getApplypostByRecruitmentId(int recruitmentId);
    
    public Applypost getApplypostByUserId(int userId);


    void save(Applypost applypost);


}
