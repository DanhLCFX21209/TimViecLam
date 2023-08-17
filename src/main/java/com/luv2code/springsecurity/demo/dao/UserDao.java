package com.luv2code.springsecurity.demo.dao;

import java.util.List;

import com.luv2code.springsecurity.demo.entity.User;

public interface UserDao {

    User findByEmail(String email);
    
    void save(User user);
    
	public User getUser(int theId);
    
    public List<User> getUsers();
    
}
