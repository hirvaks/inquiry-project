package com.example.Tiim_Scrum_Projekti.web;

import com.example.Tiim_Scrum_Projekti.domain.AnswerRepository;
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

	@Autowired
	private AnswerRepository answerRepository;

	// Admin page
	@RequestMapping(value = {"/admin", "/"}, method = RequestMethod.GET)
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

	// Delete Questionare
	@RequestMapping(value="/questionare/{id}/delete", method = RequestMethod.GET)
	public String deleteQuestionare(@PathVariable("id") Long id, @Valid Model model) {
		questionareRepository.deleteById(id);
		return "redirect:/questionares";
	}

	// List all questionares
	@RequestMapping(value="/questionares", method = RequestMethod.GET)
	public String getQuestionares(@Valid Model model) {
		model.addAttribute("questionares", questionareRepository.findAll());
		return "questionares";
	}

	// List a questionares questions
	@RequestMapping(value="/questionare/{id}/questions", method = RequestMethod.GET)
	public String getQuestionareQuestions(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Questionare> questionare = questionareRepository.findById(id);
		questionare.ifPresent(foundQuestionareObject -> model.addAttribute("questionare", foundQuestionareObject));
		model.addAttribute("questions", questionRepository.findByQuestionareId(id));
		return "questionarequestions";
	}

	// Show answers
	@RequestMapping(value = "/question/{id}/answers")
	public String getAnswers(@PathVariable("id") Long id, @Valid Model model) {
		Optional<Question> question = questionRepository.findById(id);
		question.ifPresent(foundQuestionObject -> model.addAttribute("question", foundQuestionObject));
		model.addAttribute("answers", answerRepository.findByQuestionId(id));
		return "answers";
	}

	// Delete Questions
	@RequestMapping(value="/question/{id}/delete", method = RequestMethod.GET)
	public String deleteQuestion(@PathVariable("id") Long id) {
		questionRepository.deleteById(id);
		return "redirect:/questionares";
	}
}
