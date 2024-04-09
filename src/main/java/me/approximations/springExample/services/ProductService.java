package me.approximations.springExample.services;

import lombok.RequiredArgsConstructor;
import me.approximations.springExample.entities.Product;
import me.approximations.springExample.exceptions.NotFoundException;
import me.approximations.springExample.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAllCustom();
    }

    public Product findById(Long id) {
        return productRepository.findByIdCustom(id).orElseThrow(() -> new NotFoundException("Product with id " + id + " not found."));
    }
}
