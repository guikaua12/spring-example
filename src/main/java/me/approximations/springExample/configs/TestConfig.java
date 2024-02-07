package me.approximations.springExample.configs;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.User;
import me.approximations.springExample.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        final User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", Instant.now());
        final User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", Instant.now());

        userRepository.saveAll(List.of(u1, u2));
    }
}
