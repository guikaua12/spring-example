package me.approximations.springExample.controllers;

import me.approximations.springExample.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        final User user = new User(1L, "Approximations", "email@approximations.software", "+1234567890", "password", Instant.now());

        return ResponseEntity.ok().body(List.of(user));
    }
}
