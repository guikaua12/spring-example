package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import me.approximations.springExample.entities.enums.OrderStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@ToString
@NoArgsConstructor(force=true)
@Entity(name="se_orders")
public class Order implements Serializable {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private final Instant moment;
    @JsonIgnore
    @Getter(value=AccessLevel.NONE)
    private Integer orderStatusCode;

    @ManyToOne
    @JoinColumn(name="client_id")
    private final User client;

    @OneToMany(mappedBy="id.order")
    private final Set<OrderItem> items = new HashSet<>();

    public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
        this.id = id;
        this.moment = moment;
        this.orderStatusCode = orderStatus.getCode();
        this.client = client;
    }

    public OrderStatus getOrderStatus() {
        if (orderStatusCode == null) return null;

        return OrderStatus.valueOf(orderStatusCode);
    }

    public void setOrderStatus(OrderStatus status) {
        this.orderStatusCode = status.getCode();
    }
}
