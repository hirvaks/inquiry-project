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

import java.util.ArrayList;
import java.util.List;

import com.example.Tiim_Scrum_Projekti.domain.Question;

@SpringBootApplication
public class TiimScrumProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(TiimScrumProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiimScrumProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner QuestionDemo(QuestionRepository qrepository, TypeRepository typerepo,
			QuestionareRepository quizrepo) {
		return (args) -> {

			Type type1 = new Type("Monivalinta");
			Type type2 = new Type("Avoin");

			typerepo.save(type1);
			typerepo.save(type2);

			log.info("save a couple of questions");

			Question question1 = new Question("Kuka on Trump?", type1);
			Question question2 = new Question("Missä on Trump?", type1);
			Question question3 = new Question("Kuka on Lump?", type2);

			qrepository.save(question1);
			qrepository.save(question2);
			qrepository.save(question3);

			List<Question> quiz1questions = new ArrayList<>();
			quiz1questions.add(question1);
			quiz1questions.add(question2);

			Questionare quiz1 = new Questionare("Trumppi", 1);
			Questionare quiz2 = new Questionare("Kysely 2", 1);

			quizrepo.save(quiz1);
			quizrepo.save(quiz2);

			quiz1.setQuestions(quiz1questions);
			quizrepo.save(quiz1);

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}

}