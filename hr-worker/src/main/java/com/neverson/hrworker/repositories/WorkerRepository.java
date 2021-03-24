package com.neverson.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neverson.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
