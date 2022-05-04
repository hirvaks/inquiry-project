package domain.question;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

class QuestionRowMapper implements RowMapper<Question> {

	@Override
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setId(rs.getInt("id"));
		question.setName(rs.getString("name"));
		question.setType(rs.getString("type"));
		return question;
	}
	
}
