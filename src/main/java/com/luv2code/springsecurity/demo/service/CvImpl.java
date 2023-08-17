package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.dao.CvDao;
import com.luv2code.springsecurity.demo.dao.RoleDao;
import com.luv2code.springsecurity.demo.dao.UserDao;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Role;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CvImpl implements CvService {

    @Autowired
    private CvDao cvDao;

	@Override
	@Transactional
	public void save(Cv cv) {
		cvDao.save(cv);
	}

	@Override
	@Transactional
	public Cv getCv(int theId) {
		return cvDao.getCv(theId);
	}

	@Override
	@Transactional
	public Cv getCvByUserId(int userId) {
		return cvDao.getCvByUserId(userId);
	}
	
}
