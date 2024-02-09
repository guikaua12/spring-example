package me.approximations.springExample.configs;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Order;
import me.approximations.springExample.entities.User;
import me.approximations.springExample.entities.enums.OrderStatus;
import me.approximations.springExample.repositories.OrderRepository;
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
    private final OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", Instant.now());
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", Instant.now());

        final Order o1 = new Order(null, Instant.now(), OrderStatus.PAID, u1);
        final Order o2 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u2);
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);

        userRepository.saveAll(List.of(u1, u2));
        orderRepository.saveAll(List.of(o1, o2));
    }
}
