package me.approximations.springExample.services;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Product;
import me.approximations.springExample.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
