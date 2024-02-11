package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.OrderItem;
import me.approximations.springExample.entities.OrderItemId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemId> {
}
