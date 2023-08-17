package com.luv2code.springsecurity.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luv2code.springsecurity.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	// add a reference to our security data source
    @Autowired
    private UserService userService;
	
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    
   @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
	
   @Override
   protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
       .antMatchers("/com").hasRole("EMPLOYEE")
       .antMatchers("/post-list/**").hasRole("MANAGER")
       .anyRequest().authenticated()           
       .and()
       .csrf().disable() // Tắt CSRF để cho phép yêu cầu multipart/form-data hoạt động
           // Cấu hình các phần khác của Spring Security
           .formLogin()
               .loginPage("/showMyLoginPage")
               .loginProcessingUrl("/auth/login")
               .usernameParameter("email")
               .passwordParameter("password")
               .successHandler(customAuthenticationSuccessHandler)
               .permitAll()
           .and()
           .logout()
           .permitAll();
   }
	//beans
	//bcrypt bean definition
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	//authenticationProvider bean definition
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService); //set the custom user details service
		auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt

		return auth;
	}
	

	  
}






