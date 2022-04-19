package com.example.Tiim_Scrum_Projekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class AdminController {

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/createquiz")
	public String makeQuiz() {
		return "createquiz";
	}

	@RequestMapping(value = "/quizzes")
	public String getQuizzes() {
		return "quizzes";
	}

	@RequestMapping(value = "/answers")
	public String getAnswers() {
		return "answers";
	}

	@RequestMapping(value = "/delete/{id}")
	public String deleteQuiz() {
		return "redirect:/quizzes";
	}
}
