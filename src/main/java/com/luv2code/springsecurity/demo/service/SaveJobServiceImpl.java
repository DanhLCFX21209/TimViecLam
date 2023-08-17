package com.luv2code.springsecurity.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springsecurity.demo.dao.SaveJobDao;
import com.luv2code.springsecurity.demo.entity.SaveJob;

@Service
public class SaveJobServiceImpl implements SaveJobService {
	
    @Autowired
    private SaveJobDao saveJobDao;

	@Override
	@Transactional
	public List<SaveJob> getSavedJobsByUserId(int userId) {
		return saveJobDao.getSavedJobsByUserId(userId);
	}

	@Override
	@Transactional
	public void deleteSaveJob(int theId) {
		saveJobDao.deleteSaveJob(theId);		
	}

	@Override
	@Transactional
	public void save(SaveJob saveJob) {
		saveJobDao.save(saveJob);
	}
	
 
}
