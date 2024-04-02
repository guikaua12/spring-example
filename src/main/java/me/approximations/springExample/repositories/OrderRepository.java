package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o WHERE o.id = ?1")
    @Override
    Optional<Order> findById(Long aLong);
}
