package com.neverson.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neverson.hrworker.entities.Worker;
import com.neverson.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

	
	@Autowired
	private WorkerRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		
		var list = repository.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById( @PathVariable("id") Long id) {
		
		var worker = repository.findById(id).get();
		
		return ResponseEntity.ok(worker);
	}
	
}
