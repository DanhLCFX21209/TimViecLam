package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.Cv;

import java.util.List;


public interface CvService {
    void save(Cv cv);
    
	public Cv getCv(int theId);
	
	public Cv getCvByUserId(int userId);


}
