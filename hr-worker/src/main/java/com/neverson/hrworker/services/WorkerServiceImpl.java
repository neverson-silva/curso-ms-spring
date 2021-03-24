package com.neverson.hrworker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neverson.hrworker.entities.Worker;
import com.neverson.hrworker.repositories.WorkerRepository;

@Service
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerRepository repository;

	@Override
	public List<Worker> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Worker> findById(Long id) {
		return repository.findById(id);
	}
	
}
