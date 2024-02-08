package me.approximations.springExample.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor
@Entity(name="se_users")
public class User implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private final Instant createdAt;
}
