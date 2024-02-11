package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Getter
@Setter
@NoArgsConstructor(force=true)
@AllArgsConstructor
@Entity(name="se_users")
public class User implements Serializable {
    @Serial private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private final Instant createdAt;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
