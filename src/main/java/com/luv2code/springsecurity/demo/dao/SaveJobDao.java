package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.SaveJob;
import com.luv2code.springsecurity.demo.entity.User;

public interface SaveJobDao {
    public List<SaveJob> getSavedJobsByUserId(int userId);
    
	public void deleteSaveJob(int theId);
	
    void save(SaveJob saveJob);


}
