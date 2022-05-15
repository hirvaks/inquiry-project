package com.example.Tiim_Scrum_Projekti.web;

import com.example.Tiim_Scrum_Projekti.domain.Question;
import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;
import com.example.Tiim_Scrum_Projekti.domain.Questionare;
import com.example.Tiim_Scrum_Projekti.domain.QuestionareRepository;
import com.example.Tiim_Scrum_Projekti.domain.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.Optional;

import javax.validation.Valid;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@CrossOrigin
@Controller
public class AdminController {

	@Autowired
	private QuestionareRepository questionareRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private TypeRepository typeRepository;

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

	// Create a questionare
	@RequestMapping(value = "/questionare/add", method = RequestMethod.GET)
	public String addQuestionare(@Valid Model model) {
		model.addAttribute("questionare", new Questionare());
		return "createquiz";
	}

	@RequestMapping(value = "/questionare/add", method = RequestMethod.POST)
	public String addQuestionare(@Valid Questionare questionare) {
		if (questionare.getName() != "" && questionare.getName() != null) {
			if (questionare.getStatus() != 0 || questionare.getStatus() != 1) {
				questionare.setStatus(0);
			}
			questionareRepository.save(questionare);
		}
		return "redirect:/admin";
	}

	// List all questionares
	@RequestMapping(value = { "/quizzes" }, method = RequestMethod.GET)
	public String getQuizzes(@Valid Model model) {
		model.addAttribute("questionares", questionareRepository.findAll());
		return "questionares";
	}

	// List a questionares questions
	@RequestMapping(value = "/questionare/{id}/questions", method = RequestMethod.GET)
	public String getGameAttributes(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Questionare> questionare = questionareRepository.findById(id);
		questionare.ifPresent(foundQuestionareObject -> model.addAttribute("questionare", foundQuestionareObject));
		model.addAttribute("questions", questionRepository.findAll());
		return "questionarequestions";
	}

	// Show answers
	@RequestMapping(value = "/answers")
	public String getAnswers() {
		return "answers";
	}

	// Delete Questions
	@RequestMapping(value="/questionare/{id}/questions/delete/{guestionid}", method = RequestMethod.GET)
	public String deleteGameAttributes(@PathVariable("id") Long id, @PathVariable("guestionid") Long guestionid) {
		Questionare questionare = questionareRepository.findById(id).get();
		Question question = questionRepository.findById(guestionid).get();
		if (questionare.hasQuestion(question)) {
			questionare.deleteQuestion(question);
			questionareRepository.save(questionare);
		}
		return "redirect:/questionare/{id}/questions";
	}
}
