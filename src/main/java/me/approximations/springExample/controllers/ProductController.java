package me.approximations.springExample.controllers;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Product;
import me.approximations.springExample.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="/products")
public class ProductController {
    private final ProductService productService;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        final Optional<Product> productOptional = productService.findById(id);

        return ResponseEntity.ok(productOptional.get());
    }
}
