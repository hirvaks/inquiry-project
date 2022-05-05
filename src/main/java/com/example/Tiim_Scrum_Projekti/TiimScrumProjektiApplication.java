package com.example.Tiim_Scrum_Projekti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Tiim_Scrum_Projekti.domain.QuestionRepository;
import com.example.Tiim_Scrum_Projekti.domain.Type;
import com.example.Tiim_Scrum_Projekti.domain.TypeRepository;
import com.example.Tiim_Scrum_Projekti.domain.Question;

@SpringBootApplication
public class TiimScrumProjektiApplication {
	private static final Logger log = LoggerFactory.getLogger(TiimScrumProjektiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TiimScrumProjektiApplication.class, args);
	}

	@Bean
	public CommandLineRunner QuestionDemo(QuestionRepository qrepository, TypeRepository typerepo) {
		return (args) -> {
			log.info("save a couple of questions");

			// System.out.println("HELLO DEVELOPER");

			Type type1 = new Type("Monivalinta");
			Type type2 = new Type("Avoin");

			typerepo.save(type1);
			typerepo.save(type2);


			qrepository.save(new Question("Kuka on Trump?", type1));
			qrepository.save(new Question("Kuka on Lump?", type2));

			log.info("fetch all questions");
			for (Question question : qrepository.findAll()) {
				log.info(question.toString());
			}

		};
	}

}