package com.example.Tiim_Scrum_Projekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class AdminController {

	@RequestMapping(value = { "/admin" }, method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@PostMapping("/login_success_handler")
	public String loginSuccessHandler() {
		System.out.println("Logging user login success...");

		return "admin";
	}

	@PostMapping("/login_failure_handler")
	public String loginFailureHandler() {
		System.out.println("Login failure handler....");

		return "login";
	}
}
