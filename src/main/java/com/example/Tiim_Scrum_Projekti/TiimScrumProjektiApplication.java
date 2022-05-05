package com.example.Tiim_Scrum_Projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;
import com.example.Tiim_Scrum_Projekti.domain.Question;

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

			// System.out.println("HELLO DEVELOPER");

			qrepository.save(new Question("Kuka on Trump?", "Monivalinta"));
			qrepository.save(new Question("Kuka on Lump?", "Avoin teksti"));

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}

}