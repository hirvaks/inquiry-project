package com.example.Tiim_Scrum_Projekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.Tiim_Scrum_Projekti.domain.Question;
import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;
import com.example.Tiim_Scrum_Projekti.domain.Questionare;
import com.example.Tiim_Scrum_Projekti.domain.QuestionareRepository;

@RestController
public class QuestionRestController {

    @Autowired
    private QuestionRepository qrepository;

    @Autowired
    private QuestionareRepository quizrepo;

    // RESTful service to get all quizzes
    @GetMapping("/questionare")
    Iterable<Questionare> getAllQuestionares() {
        return quizrepo.findAll();
    }

    // RESTful service to get all questions
    @GetMapping("/questions")
    Iterable<Question> getAll() {
        return qrepository.findAll();
    }

    // RESTful service to add a question
    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return qrepository.save(newQuestion);
    }

    // RESTful service to update a existing questions
    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        newQuestion.setId(id);
        return qrepository.save(newQuestion);
    }

    // RESTful to delete questions
    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        qrepository.deleteById(id);

    }

}