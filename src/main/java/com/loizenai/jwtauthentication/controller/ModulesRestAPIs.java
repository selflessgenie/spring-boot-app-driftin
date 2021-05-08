package com.loizenai.jwtauthentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loizenai.jwtauthentication.model.Module;
import com.loizenai.jwtauthentication.repository.ModuleRepository;
import com.loizenai.jwtauthentication.repository.projections.ModuleIdNameDescription;
import com.loizenai.jwtauthentication.repository.projections.QuizQuery;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api")
public class ModulesRestAPIs {
	
	@Autowired
	private ModuleRepository moduleRepository;
	
	@GetMapping("/modules")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<ModuleIdNameDescription>> getModulesList() {
		return ResponseEntity.ok(moduleRepository.findAllBy());
	}
	
	@GetMapping("/modules/{module_id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Module> getModuleById(@PathVariable Long module_id) {
		return ResponseEntity.ok(moduleRepository.findById(module_id).get());
	}
	
	@PostMapping("/modules")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Module>> addModules(@RequestBody List<Module> modules) {
		moduleRepository.saveAll(modules);
		return new ResponseEntity<List<Module>>(modules, HttpStatus.OK);
	}
	
	@PostMapping("/module")
	@PreAuthorize("hasRole('ROLE_USER')")
	public ResponseEntity<Module> addModule(@RequestBody Module module) {
		moduleRepository.save(module);
		return new ResponseEntity<Module>(module, HttpStatus.OK);
	}
	
	@GetMapping("/quiz/{quizId}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<QuizQuery>> getQuizList(@PathVariable Long quizId) {
		return ResponseEntity.ok(moduleRepository.findAllById(quizId));
	}
}