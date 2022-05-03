package com.example.Tiim_Scrum_Projekti.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Tiim_Scrum_Projekti.domain.Question;
import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;

@RestController
@Controller
public class QuestionRestController {

    @Autowired
    private QuestionRepository qrepository;

    @GetMapping("/questions")
    Iterable<Question> getAll() {
        return qrepository.findAll();
    }

    @PostMapping("/questions")
    Question newQuestion(@RequestBody Question newQuestion) {
        return qrepository.save(newQuestion);
    }

    @PutMapping("/questions/{id}")
    Question replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {
        newQuestion.setId(id);
        return qrepository.save(newQuestion);
    }

    @DeleteMapping("/questions/{id}")
    void deleteQuestion(@PathVariable Long id) {
        qrepository.deleteById(id);
    }

}