package me.approximations.springExample.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Order;
import me.approximations.springExample.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/orders")
public class OrderController {
    private final OrderService orderService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Order>> findAll() {
        return ResponseEntity.ok(orderService.findAll());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        final Optional<Order> orderOptional = orderService.findById(id);

        if (orderOptional.isEmpty()) {
            throw new RuntimeException("Order not found.");
        }
        
        return ResponseEntity.ok(orderOptional.get());
    }
}
