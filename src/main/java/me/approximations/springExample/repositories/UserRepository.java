package me.approximations.springExample.repositories;

import me.approximations.springExample.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
