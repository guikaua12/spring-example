package me.approximations.springExample.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@Data
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
@Entity(name="se_orders")
public class Order implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private final Instant moment;

    @ManyToOne
    @JoinColumn(name="client_id")
    private final User client;
}
