package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.client LEFT JOIN FETCH o.payment LEFT JOIN FETCH o.items oi LEFT JOIN FETCH oi.id.product oip LEFT JOIN FETCH oip.categories WHERE o.id = :id")
    Optional<Order> findByIdCustom(Long id);

    @Query("SELECT o FROM Order o LEFT JOIN FETCH o.client LEFT JOIN FETCH o.payment LEFT JOIN FETCH o.items oi LEFT JOIN FETCH oi.id.product oip LEFT JOIN FETCH oip.categories")
    List<Order> findAllCustom();
}
