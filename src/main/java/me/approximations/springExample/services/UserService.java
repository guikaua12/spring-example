package me.approximations.springExample.services;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.User;
import me.approximations.springExample.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        final Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }

        return userOptional;
    }

}
