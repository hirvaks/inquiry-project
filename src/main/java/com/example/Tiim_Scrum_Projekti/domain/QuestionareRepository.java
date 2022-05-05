package com.example.Tiim_Scrum_Projekti.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface QuestionareRepository extends CrudRepository<Questionare, Long> {
	List<Questionare> findByName(String name);

	Optional<Questionare> findById(Long id);

	List<Questionare> findAll();
}
