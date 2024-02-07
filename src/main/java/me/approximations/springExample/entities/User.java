package me.approximations.springExample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor
public class User {
    private final Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private final Instant createdAt;
}
