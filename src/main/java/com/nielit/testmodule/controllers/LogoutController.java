package com.nielit.testmodule.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LogoutController {

	@GetMapping("/logout")
	public String logoutUser(HttpServletRequest req, RedirectAttributes red) {
		HttpSession session = req.getSession();
		session.removeAttribute("loginid");
		session.removeAttribute("id");
		red.addFlashAttribute("message", "You are Successfully logout");
		return "redirect:/";
	}
}
