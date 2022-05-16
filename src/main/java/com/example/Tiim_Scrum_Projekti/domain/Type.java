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
public class Type {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", orphanRemoval = true)
	@JsonIgnore
	private List<Answer> answers;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "type", orphanRemoval = true)
    @JsonIgnore
    private List<Question> questions;
	
	public Type(String name) {
		super();
		this.name = name;
	}
	
	public Type() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswers(){
		return answers;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public List<Question> getQuestions(){
		return questions;
	}

	@Override
	public String toString() {
		return "name=" + name + ", id=" + id;
	}
}
