package com.neverson.hrworker.services;

import java.util.List;
import java.util.Optional;

import com.neverson.hrworker.entities.Worker;

public interface WorkerService {

	List<Worker> findAll();
	
	Optional<Worker> findById(Long id);
}
