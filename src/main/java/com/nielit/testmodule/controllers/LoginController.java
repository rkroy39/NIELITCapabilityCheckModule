package com.nielit.testmodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nielit.testmodule.beans.LoginBean;
import com.nielit.testmodule.entities.LoginDetails;
import com.nielit.testmodule.repository.LoginRepository;
import com.nielit.testmodule.util.TokenCreation;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class LoginController {

	@Autowired
	LoginRepository loginRepository;

	@GetMapping("/login")
	public String loginPage(Model model, HttpServletRequest req) {
		TokenCreation tokencreation = new TokenCreation();
		String token = tokencreation.createCSRFToken();
		model.addAttribute("logintoken", token);
		req.getSession().setAttribute("logintoken", token);
		return "loginpage";
	}

	@PostMapping("/login")
	public String loginSubmit(LoginBean logindetails, HttpServletRequest req, Model m, RedirectAttributes red) {
		HttpSession session = req.getSession();
		String tokenfromReq = (String) session.getAttribute("logintoken");
		System.out.println(req.getSession().getAttribute("logintoken"));

		if (logindetails != null && tokenfromReq != null && tokenfromReq.equals(logindetails.getLogintoken())) {
			LoginDetails test = loginRepository.checkLogin(logindetails.getLoginid(), logindetails.getPassword());
			if (test!=null) {
				session.setAttribute("loginid", test.getLoginid());
				session.setAttribute("id", test.getId());
				session.removeAttribute("logintoken");
				return "redirect:/profile";
			} else {
				red.addFlashAttribute("message", "Username/Password wrong");
				return "redirect:/login";
			}
		}
		m.addAttribute("message", "Issue in Login Controller");
		return "error";
	}
}
