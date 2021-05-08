package com.loizenai.jwtauthentication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.loizenai.jwtauthentication.repository.projections.ModuleIdNameDescription;
import com.loizenai.jwtauthentication.repository.projections.QuizQuery;

import org.springframework.stereotype.Repository;

import com.loizenai.jwtauthentication.model.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{
	public List<ModuleIdNameDescription> findAllBy();
	public List<QuizQuery> findAllById(Long id);
}
