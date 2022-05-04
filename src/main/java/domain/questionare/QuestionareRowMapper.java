package domain.questionare;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class QuestionareRowMapper implements RowMapper<Questionare> {

	@Override
	public Questionare mapRow(ResultSet rs, int rowNum) throws SQLException {
		Questionare questionare = new Questionare();
		questionare.setId(rs.getInt("id"));
		questionare.setName(rs.getString("name"));
		questionare.setStatus(rs.getBoolean("status"));
		return questionare;
	}
	
}
