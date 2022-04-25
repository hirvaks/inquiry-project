package domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface QuestionareRepository extends CrudRepository<Questionare, Long> {
	List<Questionare> findByName(String name);
}
