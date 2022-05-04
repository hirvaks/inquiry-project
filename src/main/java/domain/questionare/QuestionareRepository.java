package domain.questionare;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionareRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly=true)
	public List<Questionare> findAll(){
		return jdbcTemplate.query("SELECT * FROM questionare", new QuestionareRowMapper());
	}

}
