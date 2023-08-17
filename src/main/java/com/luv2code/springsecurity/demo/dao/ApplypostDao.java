package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.SaveJob;


public interface ApplypostDao {

	public List<Applypost> getApplyposts();
	
	public void deleteApplypost(int theId);
	
    public Applypost getApplypostByRecruitmentId(int recruitmentId);
    
    public Applypost getApplypostByUserId(int userId);

    void save(Applypost applypost);
}
