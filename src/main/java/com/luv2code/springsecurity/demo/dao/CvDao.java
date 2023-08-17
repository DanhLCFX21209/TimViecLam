package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.User;


public interface CvDao {
    void save(Cv cv);
	public Cv getCv(int theId);
	
	public Cv getCvByUserId(int userId);


}
