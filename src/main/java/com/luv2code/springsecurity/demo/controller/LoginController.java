package com.luv2code.springsecurity.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage")
	public String login() {
		return "fancy-login";
	}
	
    @GetMapping("/logout")
    public String logout() {
        // Xử lý các hoạt động cần thiết khi người dùng đăng xuất

        // Chuyển hướng người dùng đến trang đăng nhập
        return "redirect:/showMyLoginPage?logout";
    }
}






