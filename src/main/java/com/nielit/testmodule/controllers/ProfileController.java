package com.nielit.testmodule.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nielit.testmodule.beans.SignupBean;
import com.nielit.testmodule.entities.LoginDetails;
import com.nielit.testmodule.entities.SignUp;
import com.nielit.testmodule.repository.LoginRepository;
import com.nielit.testmodule.repository.SignUpRepository;
import com.nielit.testmodule.util.TokenCreation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ProfileController {

	@Autowired
	SignUpRepository signUpRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/profile")
	public String profilePage(HttpServletRequest req,Model model) {
		HttpSession  session= req.getSession();
		String loginid= (String) session.getAttribute("loginid");
		Long id= (Long) session.getAttribute("id");
		if(loginid!=null && id!=null ) {
			SignUp userdata=signUpRepository.getUserdata(loginid);
			TokenCreation tokencreation=new TokenCreation();
			String token=tokencreation.createCSRFToken();
			model.addAttribute("profiletoken", token);
			req.getSession().setAttribute("profiletoken", token);
			model.addAttribute("userdata", userdata);
		return "profile";}
		else {
			model.addAttribute("message", "Access Denied");
			return "error";
		}
	}
	
	
	
	@PostMapping("/updateProfile")
	public String updateProfile(SignupBean signupBean,HttpServletRequest req,RedirectAttributes red,Model model) {
		HttpSession  session= req.getSession();
		String loginid= (String) session.getAttribute("loginid");
		String profiletoken= (String) session.getAttribute("profiletoken");
		if(loginid!=null && signupBean!=null && profiletoken.equals(signupBean.getToken())) {
			SignUp userdata=signUpRepository.getUserdata(loginid);
			userdata.setEmail(signupBean.getUemail());
			userdata.setUsername(signupBean.getUmane());
			userdata.setMobile(signupBean.getUmobile());
			userdata.setPassword(signupBean.getPassword());
			userdata.setUpdated_at(new Date());
			signUpRepository.save(userdata);
			
			LoginDetails logindata=loginRepository.getUserdata(loginid);
			logindata.setPassword(userdata.getPassword());
			logindata.setUpdated_at(new Date());
			loginRepository.save(logindata);
			red.addFlashAttribute("message", "Your Profile is Updated");
			return "redirect:/profile";
		}
		model.addAttribute("message", "Access Denied");
		return "error";
	}
}
