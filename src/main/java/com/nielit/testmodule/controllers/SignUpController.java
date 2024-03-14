package com.nielit.testmodule.controllers;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nielit.testmodule.beans.SignupBean;
import com.nielit.testmodule.entities.LoginDetails;
import com.nielit.testmodule.entities.SignUp;
import com.nielit.testmodule.repository.LoginRepository;
import com.nielit.testmodule.repository.SignUpRepository;
import com.nielit.testmodule.util.TokenCreation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class SignUpController {

	@Autowired
	SignUpRepository signUpRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/")
	public String homePage() {
		
		return "home";
	}
	
	
	@GetMapping("/signup")
	public String signUpPage(Model model, HttpServletRequest req) {
		TokenCreation tokencreation=new TokenCreation();
		String token=tokencreation.createCSRFToken();
		model.addAttribute("token", token);
		req.getSession().setAttribute("token", token);
		return "signup";
		
	}
	@PostMapping("/signup")
	public String submitSignUpData(SignupBean signupbean, HttpServletRequest req,Model m ) {
		String tokenfromReq=(String) req.getSession().getAttribute("token");
		System.out.println(req.getSession().getAttribute("token"));
		SignUp signUp=new SignUp();
		LoginDetails login=new LoginDetails();
		if( signupbean!=null && tokenfromReq!=null && tokenfromReq.equals(signupbean.getToken()))
		{
			signUp.setCreated_at(new Date());
			signUp.setEmail(signupbean.getUemail());
			signUp.setMobile(signupbean.getUmobile());
			signUp.setPassword(signupbean.getPassword());
			signUp.setUsername(signupbean.getUmane());
			signUp.setUserid(signupbean.getUserid());
			signUp.setIscompleted(true);
			signUpRepository.save(signUp);

			
			login.setCreated_at(new Date());
			login.setLogin_attempt(0);
			login.setLoginid(signUp.getUserid());
			login.setPassword(signUp.getPassword());
			loginRepository.save(login);
			req.getSession().removeAttribute("token");
			return "redirect:/login";
		}
		m.addAttribute("message", "Issue in SignUp Controller");
		return"error";	}
	
}
