package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Order;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph(value="order-entity-graph", type=EntityGraph.EntityGraphType.LOAD)
    Optional<Order> findById(Long id);
}
