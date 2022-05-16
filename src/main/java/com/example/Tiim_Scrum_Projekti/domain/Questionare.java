package com.example.Tiim_Scrum_Projekti.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Questionare {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private int status;

    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "questionare", orphanRemoval = true)
    @JsonIgnore
    private List<Question> questions;

    public Questionare(String name, int status, List<Question> questions) {
        this.name = name;
        this.status = status;
        this.questions = questions;
    }
    public Questionare(String name, int status) {
        this.name = name;
        this.status = status;
    }

    public Questionare() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    //kysymyksen lisäys
    public void addQuestion(Question question) {
		questions.add(question);
	}

    //onko kysymys kyselyssä
    public boolean hasQuestion(Question question) {
		return questions.contains(question);
	}
	
    //kysymyksen poisto
	public void deleteQuestion(Question question) {
		questions.remove(question);
	}

    @Override
    public String toString() {
        return "Questionare [id=" + id + ", name=" + name + ", status=" + status + "]";
    }

}
