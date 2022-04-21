package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@Entity
public class Answer {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String value;
    private String type;

    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "questionareid")
    private Question question;

    public Answer(long id, String value, String type, Question question) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public Answer() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer [id=" + id + ", question=" + question + ", type=" + type + ", value=" + value + "]";
    }

}
