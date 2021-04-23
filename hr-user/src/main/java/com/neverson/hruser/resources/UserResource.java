package com.neverson.hruser.resources;

import com.neverson.hruser.entities.User;
import com.neverson.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {

        Optional<User> userOpt = userRepository.findById(id);

        return userOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam("email") String email) {

        Optional<User> userOpt = userRepository.findByEmail(email);

        return userOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

}
