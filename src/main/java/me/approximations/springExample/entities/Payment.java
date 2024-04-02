package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "se_order_payments")
public class Payment {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long id;
    private final Instant moment;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;
}
