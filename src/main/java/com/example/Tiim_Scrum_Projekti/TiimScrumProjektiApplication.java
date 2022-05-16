package com.example.Tiim_Scrum_Projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;
import com.example.Tiim_Scrum_Projekti.domain.Questionare;
import com.example.Tiim_Scrum_Projekti.domain.QuestionareRepository;
import com.example.Tiim_Scrum_Projekti.domain.Type;
import com.example.Tiim_Scrum_Projekti.domain.TypeRepository;


import com.example.Tiim_Scrum_Projekti.domain.Answer;
import com.example.Tiim_Scrum_Projekti.domain.AnswerRepository;
import com.example.Tiim_Scrum_Projekti.domain.Question;

@SpringBootApplication
public class TiimScrumProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(TiimScrumProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiimScrumProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner QuestionDemo(QuestionRepository qrepository, TypeRepository typerepo,
			QuestionareRepository questionarerepo, AnswerRepository answerrepo) {
		return (args) -> {

			//creating types
			Type type1 = new Type("Monivalinta");
			Type type2 = new Type("Avoin");
			//saving types
			typerepo.save(type1);
			typerepo.save(type2);

			//creating questionares
			Questionare questionare1 = new Questionare("Trumppi", 1);
			Questionare questionare2 = new Questionare("Kysely 2", 1);
			//saving questionares
			questionarerepo.save(questionare1);
			questionarerepo.save(questionare2);

			log.info("save a couple of questions");
			//creating questions and saving them
			Question question1 = new Question("Kuka on Trump?", type1, questionare1);
			Question question2 = new Question("Missä on Trump?", type1, questionare1);
			Question question3 = new Question("Kuka on Lump?", type2, questionare2);
			qrepository.save(question1);
			qrepository.save(question2);
			qrepository.save(question3);
			

			//creating answers to question 1 and saving
			Answer answer1question1 = new Answer("Joku luuseri", type1, question1);
			Answer answer2question1 = new Answer("Entinen presidentti", type1, question1);
			Answer answer3question1 = new Answer("Eikse ollu diilissä?", type1, question1);
			answerrepo.save(answer1question1);
			answerrepo.save(answer2question1);
			answerrepo.save(answer3question1);

			//creating answer to question 2 and saving etc.
			Answer answer1question2 = new Answer("Jaa-a, ei oikee oo tietoo", type1);
			answerrepo.save(answer1question2);

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}

}