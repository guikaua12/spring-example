package me.approximations.springExample.services;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Order;
import me.approximations.springExample.exceptions.NotFoundException;
import me.approximations.springExample.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAllCustom();
    }

    public Order findById(Long id) {
        return orderRepository.findByIdCustom(id).orElseThrow(() -> new NotFoundException("Order with id " + id + " not found."));
    }

}
