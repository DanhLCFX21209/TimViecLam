package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User findByUserName(String email);

    void save(CrmUser crmUser);
    
    void SaveUser(User theUser);
    
	public User getUser(int theId);

    
    public List<User> getUsers();

}
