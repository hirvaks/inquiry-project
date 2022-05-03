package com.example.Tiim_Scrum_Projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import domain.Question;
import domain.QuestionRepository;

@SpringBootApplication
public class TiimScrumProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(TiimScrumProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiimScrumProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner QuestionDemo(QuestionRepository qrepository) {
		return (args) -> {
			log.info("save a couple of questions");

			System.out.println("HELLO I AM HERE");

			qrepository.save(new Question(0, "Kuka on Trump?", "Monivalinta", null, null));
			qrepository.save(new Question(1, "Kuka on Lump?", "Avoin teksti", null, null));

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}

}