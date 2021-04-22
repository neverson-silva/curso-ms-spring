package com.neverson.hrworker.resources;

import com.neverson.hrworker.entities.Worker;
import com.neverson.hrworker.services.WorkerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    @Autowired
    private Environment environment;

    @Autowired
    private WorkerService service;

    @Value("${test.config}")
    private String config;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {

        var list = service.findAll();

        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {

//        try {
//            Thread.sleep(3000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Optional<Worker> worker = service.findById(id);

        if (worker.isPresent()) {
            return ResponseEntity.ok(worker.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/configs")
    public ResponseEntity<Void> configs() {

        logger.info("CONFIG = " + config);

        return ResponseEntity.noContent().build();


    }

}
