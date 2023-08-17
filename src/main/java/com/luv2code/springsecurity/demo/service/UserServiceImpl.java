package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.dao.RoleDao;
import com.luv2code.springsecurity.demo.dao.UserDao;
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
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User findByUserName(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
        user.setEmail(crmUser.getEmail());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFullName(crmUser.getFullName());

        // Tạo đối tượng Role từ roleName
        Role role = new Role();
        role.setId(crmUser.getRole());
        
        // Đặt role cho user
        user.setRole(role);
        
        userDao.save(user);
    }

    
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
                mapRolesToAuthorities(user.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Role role) {
        return Arrays.asList(new SimpleGrantedAuthority(role.getRoleName()));
    }

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public void SaveUser(User theUser) {
		userDao.save(theUser);
		
	}
    
	@Override
	@Transactional
	public User getUser(int theId) {
		return userDao.getUser(theId);
	}
    
}
