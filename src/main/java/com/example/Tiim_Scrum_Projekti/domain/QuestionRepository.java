package com.example.Tiim_Scrum_Projekti.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {

	List<Question> findByName(String name);

	Optional<Question> findById(Long id);

	List<Question> findAll();

	List<Question> findByQuestionareId(Long id);
}