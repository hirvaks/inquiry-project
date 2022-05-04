package domain.answer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class AnswerRowMapper implements RowMapper<Answer> {

	@Override
	public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Answer answer = new Answer();
		answer.setId(rs.getInt("id"));
		answer.setValue(rs.getString("value"));
		answer.setType(rs.getString("type"));
		return answer;
	}
	
}
