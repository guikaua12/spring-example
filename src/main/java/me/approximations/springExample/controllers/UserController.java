package me.approximations.springExample.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.User;
import me.approximations.springExample.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/users")
public class UserController {
    private final UserService userService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<User>> getUsers() {
        final List<User> users = userService.findAll();

        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value="/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        final Optional<User> userOptional = userService.findById(id);

        return ResponseEntity.ok(userOptional.get());
//        return userOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
