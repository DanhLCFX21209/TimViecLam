package com.luv2code.springsecurity.demo.config;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.SaveJob;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.ApplypostService;
import com.luv2code.springsecurity.demo.service.CompanyService;
import com.luv2code.springsecurity.demo.service.CvService;
import com.luv2code.springsecurity.demo.service.RecruitmentService;
import com.luv2code.springsecurity.demo.service.SaveJobService;
import com.luv2code.springsecurity.demo.service.UserService;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;
    
    @Autowired
    private CompanyService companyService;
    
    @Autowired
    private RecruitmentService recruitmentService;
    
    @Autowired
    private SaveJobService saveJobService;
    
    @Autowired
    private ApplypostService applypostService;
    
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		System.out.println("\n\nIn customAuthenticationSuccessHandler\n\n");

		String email = authentication.getName();
		
		System.out.println("email=" + email);

		User theUser = userService.findByUserName(email);
		

		// Lấy thông tin công ty từ CompanyService
	    Company companyInformation = companyService.getCompanyByUserId(theUser.getId());


		// Lấy danh sách bài đăng đã được lưu bởi người dùng
		
	  
		// now place in the session
		HttpSession session = request.getSession();
		session.setAttribute("user", theUser);
	    session.setAttribute("companyInformation", companyInformation);

		// forward to home page
		
		response.sendRedirect(request.getContextPath() + "/");
	}

}
