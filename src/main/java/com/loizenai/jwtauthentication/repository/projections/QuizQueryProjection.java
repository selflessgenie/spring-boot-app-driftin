package com.loizenai.jwtauthentication.repository.projections;

public interface QuizQueryProjection {
	Long getId();
	String getQuestion();
	String getOptions();
	String getQuiztype();
}
