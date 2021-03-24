package com.neverson.hrworker.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neverson.hrworker.entities.Worker;
import com.neverson.hrworker.repositories.WorkerRepository;
import com.neverson.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

	
	@Autowired
	private WorkerService service;
	
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		
		var list = service.findAll();
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity findById( @PathVariable("id") Long id) {
		
		Optional<Worker> worker = service.findById(id);
		
		if (worker.isPresent()) {
			return ResponseEntity.ok(worker.get());
		} else {
			return ResponseEntity.notFound().build(); 
		}
		
	}
	
}
