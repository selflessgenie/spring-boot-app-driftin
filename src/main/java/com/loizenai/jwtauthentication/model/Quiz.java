package com.loizenai.jwtauthentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "quizes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "question"
        })
})
public class Quiz {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    @Size(min=3, max = 500)
	private String question;
	
	@NotBlank
	private String options;
	
	
	private String answer; 
	
	//RadioButton or RadioTrackButton or CheckBox
	@NotBlank
	private String quiztype;
	
	//Scorable or non-scorable
	@NotBlank
	private String questiontype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public String getQuiztype() {
		return quiztype;
	}

	public void setQuiztype(String quiztype) {
		this.quiztype = quiztype;
	}

	public String getQuestiontype() {
		return questiontype;
	}

	public void setQuestiontype(String questiontype) {
		this.questiontype = questiontype;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
