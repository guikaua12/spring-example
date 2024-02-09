package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
