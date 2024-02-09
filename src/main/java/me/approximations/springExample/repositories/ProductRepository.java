package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
