package com.loizenai.jwtauthentication.repository.projections;

import java.util.List;

public interface QuizQuery {
	List<QuizQueryProjection> getQuizes();
}
