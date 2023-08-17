package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.SaveJob;

import java.util.List;


public interface SaveJobService {

	List<SaveJob> getSavedJobsByUserId(int userId);

	void deleteSaveJob(int theId);
	
    void save(SaveJob saveJob);


}
