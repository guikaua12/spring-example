package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.categories WHERE p.id = :id")
    Optional<Product> findByIdCustom(Long id);

    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.categories")
    List<Product> findAllCustom();
}
