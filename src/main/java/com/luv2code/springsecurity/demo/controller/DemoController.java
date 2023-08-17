package com.luv2code.springsecurity.demo.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.luv2code.springsecurity.demo.dao.SaveJobDao;
import com.luv2code.springsecurity.demo.entity.Applypost;
import com.luv2code.springsecurity.demo.entity.Category;
import com.luv2code.springsecurity.demo.entity.Company;
import com.luv2code.springsecurity.demo.entity.Cv;
import com.luv2code.springsecurity.demo.entity.Recruitment;
import com.luv2code.springsecurity.demo.entity.SaveJob;
import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.service.ApplypostService;
import com.luv2code.springsecurity.demo.service.CategoryService;
import com.luv2code.springsecurity.demo.service.CompanyService;
import com.luv2code.springsecurity.demo.service.CvService;
import com.luv2code.springsecurity.demo.service.RecruitmentService;
import com.luv2code.springsecurity.demo.service.SaveJobService;
import com.luv2code.springsecurity.demo.service.UserService;
import com.luv2code.springsecurity.demo.user.CrmUser;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@Controller
public class DemoController {

	// need to inject our customer service
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private RecruitmentService recruitmentService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ApplypostService applypostService;
	
	@Autowired
	private CvService cvService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SaveJobService saveJobService;
	
	@GetMapping("/")
	public String showHome(Model theModel) {
		//get customers from the service
		List<Company> company = companyService.getCompanies();
		List<Recruitment> recruitments = recruitmentService.getRecruitments();
		List<Category> categories = categoryService.getCategories();
		List<Applypost> applyposts = applypostService.getApplyposts();

		// add the customers to the model
		 theModel.addAttribute("company", company);
		 theModel.addAttribute("recruitments", recruitments);
		 theModel.addAttribute("categories", categories);
		 theModel.addAttribute("applyposts", applyposts);

		return "home";
	}
	@GetMapping("/detailCompany")
	public String detailCompany() {
		
		return "detail-company";
	}
	@GetMapping("/detail-post/{recruitmentId}")
	public String detailPost(@PathVariable("recruitmentId") int theId, Model model) {
		System.out.println(theId);
		
        Recruitment recruitment = recruitmentService.getRecruitment(theId);

        model.addAttribute("recruitment", recruitment);
		return "detail-post";
	}
	
	@GetMapping("/edit-job/{recruitmentId}")
	public String editJob(@PathVariable("recruitmentId") int theId, Model model) {
		System.out.println(theId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(theId);
        model.addAttribute("recruitment", theRecruitment);

		return "edit-job";
	}
	@GetMapping("/list-apply-job")
	public String listApplyJob() {
		
		return "list-apply-job";
	}

	@GetMapping("/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/post-list")
	public String postList(Model theModel,Authentication authentication) {
		String email = authentication.getName();
		System.out.println(email);
		User theUser = userService.findByUserName(email);
		
		List<SaveJob> theSaveJob = saveJobService.getSavedJobsByUserId(theUser.getId());
		
		theModel.addAttribute("savejobs", theSaveJob);
				
		return "post-list";
	}

	@GetMapping("/list-user")
	public String listUser(Model theModel) {
		List<User> users = userService.getUsers();
		theModel.addAttribute("users", users);

		return "list-user";
	}
	
	@GetMapping("/result-search")
	public String resultSearch(@RequestParam("keySearch") String keySearch, Model model) {
        List<Recruitment> searchResults = recruitmentService.findByRecruitmentName(keySearch);
        model.addAttribute("searchResults", searchResults);
		return "result-search";
	}
	
	


	
	@PostMapping("/update-profile")
	public String updateProfile(
			@RequestParam("userId") int theId,
			@RequestParam("fullName") String fullName,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("description") String description,
            HttpSession session) {
		
		User theUser = userService.getUser(theId);

		theUser.setEmail(email);
		theUser.setFullName(fullName);
		theUser.setAddress(address);
		theUser.setPhoneNumber(phoneNumber);
		theUser.setDescription(description);

		userService.SaveUser(theUser);
		
	    // Cập nhật thông tin người dùng trong session
	    session.setAttribute("user", theUser);

		return "redirect:/profile";

	}
	
	@PostMapping("/update-avatar")
	public String updateProfile(
			@RequestParam("userId") int theId,
			@RequestParam("file") MultipartFile file,
            HttpSession session) {
		
		User theUser = userService.getUser(theId);

        String imageName = file.getOriginalFilename();
        System.out.println(imageName);
        theUser.setImage(imageName);
        
		userService.SaveUser(theUser);
		
	    // Cập nhật thông tin người dùng trong session
	    session.setAttribute("user", theUser);

		return "redirect:/profile";

	}
	
	
	@PostMapping("/update-company")
	public String updateCompany(
			@RequestParam(value = "companyId", required = false, defaultValue = "0") int theId,
			@RequestParam("nameCompany") String nameCompany,
			@RequestParam("email") String email,
			@RequestParam("address") String address,
            @RequestParam("phoneNumber") String phoneNumber,
            @RequestParam("description") String description,
            @RequestParam("file") MultipartFile file,
            HttpSession session) {
		System.out.println("the companyId: " + file);
		System.out.println("the companyId: " + theId);

		if (theId == 0) {
			// Thêm công ty mới
			User theUser = (User) session.getAttribute("user");

			Company newCompany = new Company();
			newCompany.setUser(theUser);
			newCompany.setEmail(email);
			newCompany.setNameCompany(nameCompany);
			newCompany.setAddress(address);
			newCompany.setPhoneNumber(phoneNumber);
			newCompany.setDescription(description);
            String imageName = file.getOriginalFilename();
            newCompany.setLogo(imageName);
	        
			companyService.save(newCompany);

			// Cập nhật thông tin công ty trong session
			session.setAttribute("companyInformation", newCompany);
		} else {
			// Cập nhật thông tin công ty hiện có
			Company theCompany = companyService.getCompany(theId);
			
			if (theCompany != null) {
				System.out.println("nhap vao cty");
				theCompany.setEmail(email);
				theCompany.setNameCompany(nameCompany);
				theCompany.setAddress(address);
				theCompany.setPhoneNumber(phoneNumber);
				theCompany.setDescription(description);
                String imageName = file.getOriginalFilename();
                theCompany.setLogo(imageName);
		        
				companyService.save(theCompany);

				// Cập nhật thông tin công ty trong session
				session.setAttribute("companyInformation", theCompany);
			}
		}

		return "redirect:/profile";

	}
	
	@GetMapping("/saveStatus/{recruitmentId}")
	public String saveStatus(@PathVariable("recruitmentId") int theId) {
		System.out.println(theId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(theId);
		if(theRecruitment.getStatus().equals("1")) {
			theRecruitment.setStatus("0");

		} else {
			theRecruitment.setStatus("1");
		}
		recruitmentService.save(theRecruitment);
		return "redirect:/";
	}
	
	@GetMapping("/saveStatusCompany/{recruitmentId}")
	public String saveStatusCompany(@PathVariable("recruitmentId") int theId) {
		Company theCompany = companyService.getCompany(theId);
		if(theCompany.getStatus().equals("1")) {
			theCompany.setStatus("0");

		} else {
			theCompany.setStatus("1");
		}
		companyService.save(theCompany);
		return "redirect:/";
	}

	@GetMapping("/list-save-job")
	public String listSaveJob(Model theModel) {
		List<Recruitment> recruitments = recruitmentService.getStatusRecruitments();
		theModel.addAttribute("recruitments", recruitments);
		return "list-save-job";
	}
	
	
	@GetMapping("/list-follow-company")
	public String listFollowCompany(Model theModel) {
		List<Company> companies = companyService.getStatusCompanies();
		theModel.addAttribute("companies", companies);
		return "list-follow-company";
	}

	@GetMapping("/post-job/{recruitmentId}")
	public String postJob(@PathVariable("recruitmentId") int theId, Model model) {
		System.out.println(theId);
		Recruitment theRecruitment = recruitmentService.getRecruitment(theId);
        model.addAttribute("recruitment", theRecruitment);

		return "post-job";
	}
	
	@GetMapping("/post-company/{companyId}")
	public String postCompany(@PathVariable("companyId") int theId, Model modell) {
		Company company = companyService.getCompany(theId);
		modell.addAttribute("company", company);
		return "post-company";
	}
	
	@GetMapping("/post-job")
	public String postJob2() {
		return "post-job";
	}
	
	@PostMapping("/addRecruitment")
	public String addRecruitment(@ModelAttribute("recruitment") Recruitment recruitment,
			@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("experience") String experience,
            @RequestParam("quantity") String quantity,
            @RequestParam("address") String address,
            @RequestParam("deadline") String deadline,
            @RequestParam("salary") String salary,
            @RequestParam("type") String type,
            Authentication authentication) {
		// save recruitment
		recruitment.setTitle(title);
		recruitment.setDescription(description);
		recruitment.setExperience(experience);
		recruitment.setQuantity(quantity);
		recruitment.setAddress(address);
		recruitment.setDeadline(deadline);
		recruitment.setSalary(salary);
		recruitment.setType(type);
		Company company = new Company();
		company.setId(1);
		recruitment.setCompany(company);
		// save SaveJob
		SaveJob theSaveJob = new SaveJob();
		String email = authentication.getName();
		User theUser = userService.findByUserName(email);
		theSaveJob.setUser(theUser);
		theSaveJob.setRecruitment(recruitment);
		recruitmentService.save(recruitment);
		saveJobService.save(theSaveJob);
		return "redirect:/post-list";
	}
	
	@PostMapping("/updateRecruitment")
	public String updateRecruitment(
			@RequestParam("recruitmentId") int recruitmentId,
			@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("experience") String experience,
            @RequestParam("quantity") String quantity,
            @RequestParam("address") String address,
            @RequestParam("deadline") String deadline,
            @RequestParam("salary") String salary,
            @RequestParam("type") String type,
            Authentication authentication) {
		// save recruitment
		Recruitment recruitment = recruitmentService.getRecruitment(recruitmentId);
		recruitment.setTitle(title);
		recruitment.setDescription(description);
		recruitment.setExperience(experience);
		recruitment.setQuantity(quantity);
		recruitment.setAddress(address);
		recruitment.setDeadline(deadline);
		recruitment.setSalary(salary);
		recruitment.setType(type);
		Company company = new Company();
		company.setId(1);
		recruitment.setCompany(company);
		recruitmentService.save(recruitment);
		
		return "redirect:/post-list";
	}
	
	@PostMapping("/recruitmentDelete")
	public String recruitmentDelete(@RequestParam("recruitmentId") int theId) {
		applypostService.deleteApplypost(theId);
		saveJobService.deleteSaveJob(theId);
		recruitmentService.deleteRecruitment(theId);
		
		return "redirect:/post-list";
	}

}










