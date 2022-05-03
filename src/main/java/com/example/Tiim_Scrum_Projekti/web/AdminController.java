package com.example.Tiim_Scrum_Projekti.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class AdminController {

	// Admin page
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin";
	}

	// Login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// Create a quiz
	@RequestMapping(value = "/createquiz")
	public String makeQuiz() {
		return "createquiz";
	}

	// List all quizzess
	@RequestMapping(value = "/quizzes")
	public String getQuizzes() {
		return "quizzes";
	}

	// Show answers
	@RequestMapping(value = "/answers")
	public String getAnswers() {
		return "answers";
	}

	// Delete Questions
	@RequestMapping(value = "/delete/{id}")
	public String deleteQuiz() {
		return "redirect:/quizzes";
	}
}
