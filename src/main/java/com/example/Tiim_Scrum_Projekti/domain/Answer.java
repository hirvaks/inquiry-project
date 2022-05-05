package com.example.Tiim_Scrum_Projekti.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String value;
    
    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "typeid")
    private Type type;

    @ManyToOne
    @JsonIgnoreProperties
    @JoinColumn(name = "questionid")
    private Question question;

    public Answer(String value, Type type) {
        this.value = value;
        this.type = type;
    }

    public Answer(String value, Type type, Question question) {
        this.value = value;
        this.type = type;
        this.question = question;
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
