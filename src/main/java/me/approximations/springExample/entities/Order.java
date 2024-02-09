package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import me.approximations.springExample.entities.enums.OrderStatus;

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
    @JsonIgnore
    @Getter(value=AccessLevel.NONE)
    private Integer orderStatusCode;

    @ManyToOne
    @JoinColumn(name="client_id")
    private final User client;

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
