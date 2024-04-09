package me.approximations.springExample.services;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Order;
import me.approximations.springExample.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAllCustom();
    }

    public Order findById(Long id) {
        final Optional<Order> orderOptional = orderRepository.findByIdCustom(id);

        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Order not found");
        }

        return orderOptional.get();
    }

}
