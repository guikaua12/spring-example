package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
