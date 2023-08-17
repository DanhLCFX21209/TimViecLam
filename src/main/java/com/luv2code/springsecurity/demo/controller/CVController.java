package com.luv2code.springsecurity.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.ApplypostService;
import com.luv2code.springsecurity.demo.service.CvService;
import com.luv2code.springsecurity.demo.service.UserService;

@Controller
public class CVController {

	@Autowired
	private CvService cvService;

	@Autowired
	private ApplypostService applypostService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/update-cv")
	public String updateCv(@RequestParam(value = "cvId", required = false, defaultValue = "0") int theId,
			@RequestParam("userId") int userId,
			@RequestParam("cvFile") String file, HttpSession session) {
		if (theId == 0) {
			// Thêm cv mới
			System.out.println("hello");
			Cv newCv = new Cv();
			newCv.setFileName(file);
			User newUser = new User();
			newUser.setId(userId);
			newCv.setUser(newUser);
			cvService.save(newCv);

			// Cập nhật thông tin cv trong session
			session.setAttribute("cv", newCv);
		} else {
			// Cập nhật cv công ty hiện có
			Cv theCv = cvService.getCv(theId);

			if (theCv != null) {
				theCv.setFileName(file);

				cvService.save(theCv);

				// Cập nhật thông tin cv trong session
				session.setAttribute("cv", theCv);
			}
		}
		return "redirect:/"; // Redirect to the user's profile page

	}
	
	@PostMapping("/apply-job")
	public String applyJob(@RequestParam("recruitmentId") int recruitmentId,
			@RequestParam("file") MultipartFile file,
			@RequestParam("introduction") String introduction,
			Authentication authentication,
			HttpSession session) {
		Applypost theApplypost = applypostService.getApplypostByRecruitmentId(recruitmentId);
		System.out.println(file);
		String fileName = file.getOriginalFilename();
		String email = authentication.getName();
		User theUser = userService.findByUserName(email);
		if(file.isEmpty()) {

			Cv theCv = cvService.getCvByUserId(theUser.getId());
			fileName = theCv.getFileName();
			System.out.println(file);
		}

		if(theApplypost == null) {
			Applypost newApplypost = new Applypost();
			newApplypost.setNameCV(fileName);
			newApplypost.setText(introduction);
			newApplypost.setUser(theUser);
			Recruitment recruitment = new Recruitment();
			recruitment.setId(recruitmentId);
			newApplypost.setRecruitment(recruitment);
			applypostService.save(newApplypost);
		} else {
			theApplypost.setNameCV(fileName);
			theApplypost.setText(introduction);		
			applypostService.save(theApplypost);

		}
		
		return "redirect:/"; // Redirect to the user's profile page

	}
}
